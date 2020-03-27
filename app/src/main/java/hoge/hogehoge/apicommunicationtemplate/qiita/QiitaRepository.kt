package hoge.hogehoge.apicommunicationtemplate.qiita

import hoge.hogehoge.apicommunicationtemplate.qiita.QiitaService
import hoge.hogehoge.apicommunicationtemplate.qiita.api.GetArticleAPI
import io.reactivex.Maybe
import io.reactivex.Observable

class QiitaRepository(
    private val qiitaService: QiitaService
) {
    fun fetchArticles(request: GetArticleAPI.Request): Maybe<GetArticleAPI.Response> {
        return qiitaService.getArticles(request.path, request.queryParameter)
            .map { GetArticleAPI.Response(it) }
    }
}