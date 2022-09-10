package br.com.hexagonal.example.infrastructure.database.repositories.adapters.mongo

import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoAdapterRepository: MongoRepository<Employee, Long> {
}