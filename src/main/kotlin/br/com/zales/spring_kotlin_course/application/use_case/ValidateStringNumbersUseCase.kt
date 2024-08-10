package br.com.zales.spring_kotlin_course.application.use_case

import br.com.zales.spring_kotlin_course.core.model.use_case.UseCase
import br.com.zales.spring_kotlin_course.core.model.use_case.validate_string_numbers.ValidateStringNumbersInput
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Component

@Component
class ValidateStringNumbersUseCase : UseCase<ValidateStringNumbersInput, Unit> {

    override fun execute(useCaseInput: ValidateStringNumbersInput) {
        val number1 = useCaseInput.number1
        val number2 = useCaseInput.number2

        if (number1.isBlank() || number2.isBlank())
            throw BadRequestException("You must provide two numbers to execute an operation of sum.")
        if (!number1.matches("^-?\\d+(\\.\\d+)?\$".toRegex()) || !number2.matches("^-?\\d+(\\.\\d+)?\$".toRegex()))
            throw BadRequestException("You must provide two numbers to execute an operation of sum.")
    }

}