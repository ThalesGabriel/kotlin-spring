package br.com.zales.spring_kotlin_course.infrastructure.controllers.person.dto

class CreatePersonRequest(
        val firstName: String,
        val lastName: String,
        val address: String
)