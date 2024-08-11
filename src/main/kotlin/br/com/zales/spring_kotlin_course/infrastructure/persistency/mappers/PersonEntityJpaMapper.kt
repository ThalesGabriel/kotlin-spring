package br.com.zales.spring_kotlin_course.infrastructure.persistency.mappers

import br.com.zales.spring_kotlin_course.domain.PersonModel
import br.com.zales.spring_kotlin_course.infrastructure.persistency.entities.PersonEntityJpa

class PersonEntityJpaMapper(
        override val id: String,
        override val firstName: String,
        override val lastName: String,
        override val address: String
) : PersonModel {

    companion object {
        fun toJpaEntity(personModel: PersonModel): PersonEntityJpa {
            return PersonEntityJpa(personModel.id, personModel.firstName, personModel.lastName, personModel.address)
        }

    }

}