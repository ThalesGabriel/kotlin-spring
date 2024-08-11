package br.com.zales.spring_kotlin_course.infrastructure.persistency.repositories

import br.com.zales.spring_kotlin_course.infrastructure.persistency.entities.PersonEntityJpa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonJpaRepository : JpaRepository<PersonEntityJpa, String?> {}