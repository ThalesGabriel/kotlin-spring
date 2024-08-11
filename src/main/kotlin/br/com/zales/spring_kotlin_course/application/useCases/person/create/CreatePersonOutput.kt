package br.com.zales.spring_kotlin_course.application.useCases.person.create

import br.com.zales.spring_kotlin_course.domain.PersonModel

data class CreatePersonOutput(
        val id: String,
        val firstName: String,
        val lastName: String,
        val address: String
) {

    companion object {
        fun fromModel(personModel: PersonModel) : CreatePersonOutput {
            return CreatePersonOutput(id = personModel.id, firstName = personModel.firstName, lastName = personModel.lastName, address = personModel.address)
        }
    }

}
