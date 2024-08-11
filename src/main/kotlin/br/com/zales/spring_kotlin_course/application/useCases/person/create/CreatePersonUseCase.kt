package br.com.zales.spring_kotlin_course.application.useCases.person.create

import br.com.zales.spring_kotlin_course.application.gateways.PersonGateway
import br.com.zales.spring_kotlin_course.application.useCases.UseCase
import br.com.zales.spring_kotlin_course.infrastructure.persistency.entities.PersonEntityJpa
import br.com.zales.spring_kotlin_course.infrastructure.persistency.mappers.PersonEntityJpaMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CreatePersonUseCase : UseCase<CreatePersonInput, CreatePersonOutput>{

    @Autowired
    lateinit var gateway: PersonGateway<PersonEntityJpa>

    override fun execute(useCaseInput: CreatePersonInput): CreatePersonOutput {
        val createdPerson = gateway.save(PersonEntityJpaMapper.toJpaEntity(useCaseInput.toModel()))
        return CreatePersonOutput.fromModel(createdPerson)
    }

}