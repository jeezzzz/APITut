package com.jeezzzz.apitut

data class MyUser(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)