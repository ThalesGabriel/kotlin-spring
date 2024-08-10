package br.com.zales.spring_kotlin_course.application.use_case

import br.com.zales.spring_kotlin_course.core.model.use_case.UseCase
import br.com.zales.spring_kotlin_course.core.model.use_case.convert_string_numbers.ConvertStringNumbersInput
import br.com.zales.spring_kotlin_course.core.model.use_case.convert_string_numbers.ConvertStringNumbersOutput
import org.springframework.stereotype.Component

@Component
class ConvertStringNumbersUseCase : UseCase<ConvertStringNumbersInput, ConvertStringNumbersOutput> {
    override fun execute(useCaseInput: ConvertStringNumbersInput): ConvertStringNumbersOutput {
        return ConvertStringNumbersOutput(listOf(useCaseInput.number1.toDouble(), useCaseInput.number2.toDouble()))
    }
}