package br.com.zales.spring_kotlin_course.infrastructure.controllers.person

import br.com.zales.spring_kotlin_course.infrastructure.controllers.person.dto.CreatePersonRequest
import br.com.zales.spring_kotlin_course.application.services.PersonService
import br.com.zales.spring_kotlin_course.domain.Person
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RequestMapping("/persons")
@RestController
class PersonController {

    private val logger = LoggerFactory.getLogger(PersonController::class.java)

    @Autowired
    lateinit var service: PersonService

//    @GetMapping("/{personId}")
//    fun findById(@PathVariable("personId") personId: String): Person {
//        return service.findById(personId)
//    }

    @PostMapping
    fun create(@RequestBody input: CreatePersonRequest): ResponseEntity<*> {
        logger.info("Received request to create a user")

        val person = service.create(input)
        return ResponseEntity.created(URI.create("/persons/${person.id}")).body(person)
    }
}