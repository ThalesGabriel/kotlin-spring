package br.com.zales.spring_kotlin_course.application.useCases

interface UseCase<Input, Output> {

    fun execute(useCaseInput: Input): Output

}