package br.com.hexagonal.example.infrastructure.repository

import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataEmployeeRepository: JpaRepository<Employee, Long> {}