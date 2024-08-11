package br.com.zales.spring_kotlin_course.infrastructure.persistency.entities

import br.com.zales.spring_kotlin_course.domain.PersonModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "person")
data class PersonEntityJpa (

        @Id
        override val id: String,

        @Column(name = "first_name", nullable = false)
        override val firstName: String,

        @Column(name = "last_name", nullable = false)
        override val lastName: String,

        @Column(nullable = false, length = 100)
        override val address: String

) : PersonModel {
        constructor() : this("", "", "", "")
}