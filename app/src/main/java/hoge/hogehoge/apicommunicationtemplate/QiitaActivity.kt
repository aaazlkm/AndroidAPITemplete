package hoge.hogehoge.apicommunicationtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hoge.hogehoge.apicommunicationtemplate.qiita.QiitaAPI
import hoge.hogehoge.apicommunicationtemplate.qiita.QiitaRepository
import hoge.hogehoge.apicommunicationtemplate.qiita.api.GetArticleAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_qiita.*

class QiitaActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    private val qiitaRepository =
        QiitaRepository(
            QiitaAPI.qiitaService
        )

    //region lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita)

        bindUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    //endregion

    //region bind methods

    private fun bindUI() {
        fetchArticleButton
            .setOnClickListener {
                fetchArticles()
            }
    }

    //endregion

    //region fetch data methods

    private fun fetchArticles() {
        val articleAPIRequest =
            GetArticleAPI.Request(
                "1",
                "20"
            )

        qiitaRepository.fetchArticles(articleAPIRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    log("$it")
                },
                onError = {
                    log("$it")
                }
            )
            .addTo(compositeDisposable)
    }

    //endregion

    //region debug methods

    private fun log(logText: String) {
        logView.text = "${logView.text}\n$logText"
    }

    //endregion
}
