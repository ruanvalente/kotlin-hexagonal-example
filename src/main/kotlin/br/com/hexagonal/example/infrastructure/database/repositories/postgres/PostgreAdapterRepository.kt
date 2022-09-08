package br.com.hexagonal.example.infrastructure.database.repositories.postgres

import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface PostgreAdapterRepository: JpaRepository<Employee, Long> {}