package br.com.zales.spring_kotlin_course.application.useCases.person.findById

import br.com.zales.spring_kotlin_course.application.gateways.PersonGateway
import br.com.zales.spring_kotlin_course.application.useCases.UseCase
import br.com.zales.spring_kotlin_course.domain.PersonModel
import br.com.zales.spring_kotlin_course.infrastructure.persistency.entities.PersonEntityJpa
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FindPersonByIdUseCase : UseCase<FindPersonByIdInput, FindPersonByIdOutput> {

    @Autowired
    lateinit var gateway: PersonGateway<PersonEntityJpa>

    override fun execute(useCaseInput: FindPersonByIdInput): FindPersonByIdOutput {
        val person = gateway.findById(useCaseInput.personId)
        return FindPersonByIdOutput.fromModel(person)
    }

}