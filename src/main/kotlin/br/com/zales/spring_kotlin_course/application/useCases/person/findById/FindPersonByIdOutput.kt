package br.com.zales.spring_kotlin_course.application.useCases.person.findById

import br.com.zales.spring_kotlin_course.domain.PersonModel

data class FindPersonByIdOutput(
        val id: String,
        val firstName: String,
        val lastName: String,
        val address: String
) {

    companion object {

        fun fromModel(model: PersonModel): FindPersonByIdOutput {
            return FindPersonByIdOutput(model.id, model.firstName, model.lastName, model.address)
        }

    }

}
