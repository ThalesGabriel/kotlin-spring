package br.com.zales.spring_kotlin_course.core.model.use_case

interface UseCase<Input, Output> {

    fun execute(useCaseInput: Input): Output

}