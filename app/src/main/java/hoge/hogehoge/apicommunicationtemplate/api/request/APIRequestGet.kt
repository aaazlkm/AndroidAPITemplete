package hoge.hogehoge.apicommunicationtemplate.api.request

import hoge.hogehoge.apicommunicationtemplate.api.response.APIResponse

interface APIRequestGet<RESPONSE> : APIRequest<RESPONSE> where RESPONSE : APIResponse {

    val queryParameter: Map<String, String>
}