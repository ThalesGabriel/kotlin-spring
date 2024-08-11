package br.com.zales.spring_kotlin_course.common

import org.apache.coyote.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllException(ex: Exception, request: WebRequest) : ResponseEntity<ExceptionResponse> {
        val exception = ExceptionResponse(Date(), ex.message ?: "Internal Server Error", request.getDescription(false))
        return ResponseEntity<ExceptionResponse>(exception, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: Exception, request: WebRequest) : ResponseEntity<ExceptionResponse> {
        val exception = ExceptionResponse(Date(), ex.message ?: "Invalid parameters", request.getDescription(false))
        return ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST)
    }

}