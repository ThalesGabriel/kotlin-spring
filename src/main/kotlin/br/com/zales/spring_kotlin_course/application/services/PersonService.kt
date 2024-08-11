package br.com.zales.spring_kotlin_course.application.services

import br.com.zales.spring_kotlin_course.application.useCases.UseCase
import br.com.zales.spring_kotlin_course.application.useCases.person.create.CreatePersonInput
import br.com.zales.spring_kotlin_course.application.useCases.person.create.CreatePersonOutput
import br.com.zales.spring_kotlin_course.application.useCases.person.findById.FindPersonByIdInput
import br.com.zales.spring_kotlin_course.application.useCases.person.findById.FindPersonByIdOutput
import br.com.zales.spring_kotlin_course.infrastructure.controllers.person.dto.CreatePersonRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    private val logger = Logger.getLogger(PersonService::class.java.name)

    @Autowired
    lateinit var findPersonByIdUseCase: UseCase<FindPersonByIdInput, FindPersonByIdOutput>

    @Autowired
    lateinit var createPersonUseCase: UseCase<CreatePersonInput, CreatePersonOutput>

    fun create(input: CreatePersonRequest): CreatePersonOutput {
        return createPersonUseCase.execute(
                CreatePersonInput(input.firstName, input.lastName, input.address)
        )
    }

}