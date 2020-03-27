package hoge.hogehoge.apicommunicationtemplate.api.request

import hoge.hogehoge.apicommunicationtemplate.api.APIConfiguration
import hoge.hogehoge.apicommunicationtemplate.api.response.APIResponse

interface APIRequest<RESPONSE> where RESPONSE : APIResponse {
    var configuration: APIConfiguration

    val path: String
        get() = configuration.path

}