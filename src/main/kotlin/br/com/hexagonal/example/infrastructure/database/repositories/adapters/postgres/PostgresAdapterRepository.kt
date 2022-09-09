package br.com.hexagonal.example.infrastructure.database.repositories.adapters.mongo.postgres

import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresAdapterRepository: JpaRepository<Employee, Long> {}