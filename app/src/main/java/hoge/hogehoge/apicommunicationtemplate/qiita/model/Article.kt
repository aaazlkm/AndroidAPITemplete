package hoge.hogehoge.apicommunicationtemplate.qiita.model

data class Article(
    val renderedBody: String?,
    val body: String?,
    val commentsCount: Int?,
    val title: String?,
    val createdAt: String?,
    val id: String?,
    val likesCount: Int?,
    val tags: List<Tag>,
    val url: String?,
    val user: User?,
    val pageViewsCount: Int?
)