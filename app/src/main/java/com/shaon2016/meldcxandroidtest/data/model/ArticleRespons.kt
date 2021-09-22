package com.sslwireless.architechture.data.model

import com.sslwireless.architechture.data.local_db.entity.Article

class ArticleRespons {

    var total_rows = 0
    lateinit var articles: List<Article>

}