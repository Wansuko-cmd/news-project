package com.wsr.model.db.entities

import java.time.LocalDateTime

data class Favorite(
    val id: Int,
    val title: String,
    val url: String,
    val createdAt: LocalDateTime
)
