package br.com.zales.spring_kotlin_course.infrastructure.controllers

import br.com.zales.spring_kotlin_course.application.services.MathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    @Autowired
    lateinit var service: MathService


    @GetMapping("/sum/{number1}/{number2}")
    fun sum(@PathVariable("number1") number1: String, @PathVariable("number2") number2: String): Double {
        return service.sumNumbers(number1, number2)
    }

    @GetMapping("/multiply/{number1}/{number2}")
    fun multiply(@PathVariable("number1") number1: String, @PathVariable("number2") number2: String): Double {
        return service.multiplyNumbers(number1, number2)
    }

    @GetMapping("/divide/{number1}/{number2}")
    fun divide(@PathVariable("number1") number1: String, @PathVariable("number2") number2: String): Double {
        return service.divideNumbers(number1, number2)
    }

    @GetMapping("/subtract/{number1}/{number2}")
    fun subtract(@PathVariable("number1") number1: String, @PathVariable("number2") number2: String): Double {
        return service.subtractNumbers(number1, number2)
    }

}