package hoge.hogehoge.apicommunicationtemplate.api.request

import hoge.hogehoge.apicommunicationtemplate.api.response.APIResponse

interface APIRequestPost<RESPONSE> : APIRequest<RESPONSE> where RESPONSE : APIResponse {

    val bodyParameter: Map<String, String>
}