package hoge.hogehoge.apicommunicationtemplate.qiita

import hoge.hogehoge.apicommunicationtemplate.api.APIConfiguration

enum class QiitaAPIConfiguration : APIConfiguration {
    GET_ARTICLES;

    override val path: String
        get() = "items"
}