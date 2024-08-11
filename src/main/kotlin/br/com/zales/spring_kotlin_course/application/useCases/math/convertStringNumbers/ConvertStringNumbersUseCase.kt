package br.com.zales.spring_kotlin_course.application.useCases.math.convertStringNumbers

import br.com.zales.spring_kotlin_course.application.useCases.UseCase
import org.springframework.stereotype.Component

@Component
class ConvertStringNumbersUseCase : UseCase<ConvertStringNumbersInput, ConvertStringNumbersOutput> {
    override fun execute(useCaseInput: ConvertStringNumbersInput): ConvertStringNumbersOutput {
        return ConvertStringNumbersOutput(listOf(useCaseInput.number1.toDouble(), useCaseInput.number2.toDouble()))
    }
}