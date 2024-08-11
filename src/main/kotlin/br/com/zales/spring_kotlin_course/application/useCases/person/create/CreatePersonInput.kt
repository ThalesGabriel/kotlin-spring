package br.com.zales.spring_kotlin_course.application.useCases.person.create

import br.com.zales.spring_kotlin_course.domain.Person
import br.com.zales.spring_kotlin_course.domain.PersonModel

data class CreatePersonInput(
        val firstName: String,
        val lastName: String,
        val address: String
) {

    fun toModel() : PersonModel {
        return Person(firstName = firstName, lastName = lastName, address = address)
    }

}
