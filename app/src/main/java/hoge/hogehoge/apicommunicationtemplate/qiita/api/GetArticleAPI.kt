package hoge.hogehoge.apicommunicationtemplate.qiita.api

import hoge.hogehoge.apicommunicationtemplate.api.APIConfiguration
import hoge.hogehoge.apicommunicationtemplate.api.request.APIRequestGet
import hoge.hogehoge.apicommunicationtemplate.api.response.APIResponse
import hoge.hogehoge.apicommunicationtemplate.qiita.QiitaAPIConfiguration
import hoge.hogehoge.apicommunicationtemplate.qiita.model.Article

object GetArticleAPI {
    data class Request(
        val page: String,
        val perPage: String
    ) : APIRequestGet<Response> {
        enum class QueryName(val queryName: String) {
            PAGE("page"),
            PER_OAGE("per_page");
        }

        override var configuration: APIConfiguration =
            QiitaAPIConfiguration.GET_ARTICLES

        override val queryParameter: Map<String, String>
            get() = mapOf(
                QueryName.PAGE.queryName to page,
                QueryName.PER_OAGE.queryName to perPage
            )
    }

    data class Response(
        val articles: List<Article>
    ) : APIResponse
}
