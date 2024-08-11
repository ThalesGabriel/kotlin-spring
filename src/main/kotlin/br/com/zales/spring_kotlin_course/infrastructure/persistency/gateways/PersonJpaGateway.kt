package br.com.zales.spring_kotlin_course.infrastructure.persistency.gateways

import br.com.zales.spring_kotlin_course.application.gateways.PersonGateway
import br.com.zales.spring_kotlin_course.infrastructure.persistency.entities.PersonEntityJpa
import br.com.zales.spring_kotlin_course.infrastructure.persistency.mappers.PersonEntityJpaMapper
import br.com.zales.spring_kotlin_course.infrastructure.persistency.repositories.PersonJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonJpaGateway : PersonGateway<PersonEntityJpa> {

    @Autowired
    lateinit var repository: PersonJpaRepository

    override fun save(newPerson: PersonEntityJpa) : PersonEntityJpa {
        return repository.save(newPerson)
    }

    override fun findById(personId: String): PersonEntityJpa {
        TODO("Not yet implemented")
    }

    override fun delete(personId: String): PersonEntityJpa {
        TODO("Not yet implemented")
    }

    override fun update(personId: String, updatedPerson: PersonEntityJpa): PersonEntityJpa {
        TODO("Not yet implemented")
    }

}