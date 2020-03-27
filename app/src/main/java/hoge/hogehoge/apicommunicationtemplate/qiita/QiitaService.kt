package hoge.hogehoge.apicommunicationtemplate.qiita

import hoge.hogehoge.apicommunicationtemplate.qiita.model.Article
import io.reactivex.Maybe
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url


interface QiitaService {

    @GET
    fun getArticles(@Url url: String, @QueryMap parameters: Map<String, String>): Maybe<List<Article>>
}
