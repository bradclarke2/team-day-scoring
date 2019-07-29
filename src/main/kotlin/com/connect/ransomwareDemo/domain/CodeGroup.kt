package com.connect.ransomwareDemo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotEmpty

@Document
data class CodeGroup(
        @Id var id: String? = null,
        @NotEmpty val users: List<User>,
        val score: ArrayList<Boolean>? = arrayListOf()
)
