package br.com.hexagonal.example.infrastructure.mappers

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.stereotype.Component

@Component
class EmployeeRequestMapper :
    Mapper<EmployeeRequestDTO, Employee> {

    override fun mapper(t: EmployeeRequestDTO): Employee {
        return Employee(name = t.name, role = t.role, salary = t.salary)
    }
}
