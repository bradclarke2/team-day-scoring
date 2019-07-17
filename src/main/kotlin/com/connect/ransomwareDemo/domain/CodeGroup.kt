package com.connect.ransomwareDemo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CodeGroup(
        @Id var id: String,
        val users: List<User>,
        val score: List<Boolean> = listOf(false, false, false, false, false, false)
)
