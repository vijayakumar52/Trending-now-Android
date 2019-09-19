package com.vijay.trendingnow.model

class ListData {
    lateinit var title: String
    lateinit var views: String
    var date: Long = 0
    lateinit var articles: List<Article>
}