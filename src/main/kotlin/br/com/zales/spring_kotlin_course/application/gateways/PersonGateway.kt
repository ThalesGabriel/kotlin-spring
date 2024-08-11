package br.com.zales.spring_kotlin_course.application.gateways

interface PersonGateway<Person> {

    fun save(newPerson: Person): Person

    fun findById(personId: String): Person

    fun update(personId: String, updatedPerson: Person): Person

    fun delete(personId: String): Person

}