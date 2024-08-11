package br.com.zales.spring_kotlin_course.domain

import java.util.UUID

data class Person (
        override val id: String = UUID.randomUUID().toString(),
        override val firstName: String = "",
        override val lastName: String = "",
        override val address: String = ""
) : PersonModel