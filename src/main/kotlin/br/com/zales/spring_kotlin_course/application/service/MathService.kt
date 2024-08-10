package br.com.zales.spring_kotlin_course.application.service

import br.com.zales.spring_kotlin_course.core.model.use_case.UseCase
import br.com.zales.spring_kotlin_course.core.model.use_case.convert_string_numbers.ConvertStringNumbersInput
import br.com.zales.spring_kotlin_course.core.model.use_case.convert_string_numbers.ConvertStringNumbersOutput
import br.com.zales.spring_kotlin_course.core.model.use_case.validate_string_numbers.ValidateStringNumbersInput
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