package br.com.zales.spring_kotlin_course.application.services

import br.com.zales.spring_kotlin_course.application.useCases.UseCase
import br.com.zales.spring_kotlin_course.application.useCases.math.convertStringNumbers.ConvertStringNumbersInput
import br.com.zales.spring_kotlin_course.application.useCases.math.convertStringNumbers.ConvertStringNumbersOutput
import br.com.zales.spring_kotlin_course.application.useCases.math.validateStringNumbers.ValidateStringNumbersInput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MathService {

    @Autowired
    lateinit var validateStringNumbers: UseCase<ValidateStringNumbersInput, Unit>

    @Autowired
    lateinit var convertStringNumbers: UseCase<ConvertStringNumbersInput, ConvertStringNumbersOutput>

    fun sumNumbers(number1: String, number2: String): Double {
        validateStringNumbers.execute(ValidateStringNumbersInput(number1, number2))
        return convertStringNumbers.execute(ConvertStringNumbersInput(number1, number2)).convertedList.sum()
    }

    fun multiplyNumbers(number1: String, number2: String): Double {
        validateStringNumbers.execute(ValidateStringNumbersInput(number1, number2))
        return convertStringNumbers.execute(ConvertStringNumbersInput(number1, number2)).convertedList.reduce { accumulator, value ->
            accumulator * value
        }
    }

    fun divideNumbers(number1: String, number2: String): Double {
        validateStringNumbers.execute(ValidateStringNumbersInput(number1, number2))
        return convertStringNumbers.execute(ConvertStringNumbersInput(number1, number2)).convertedList.reduce { accumulator, value ->
            accumulator / value
        }
    }

    fun subtractNumbers(number1: String, number2: String): Double {
        validateStringNumbers.execute(ValidateStringNumbersInput(number1, number2))
        return convertStringNumbers.execute(ConvertStringNumbersInput(number1, number2)).convertedList.reduce { accumulator, value ->
            accumulator - value
        }
    }

}