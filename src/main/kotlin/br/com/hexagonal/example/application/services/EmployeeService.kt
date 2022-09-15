package br.com.hexagonal.example.application.services

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.ports.domain.Employee
import br.com.hexagonal.example.application.ports.respository.EmployeeRepositoryPort
import br.com.hexagonal.example.infrastructure.exceptions.EmployeeException
import br.com.hexagonal.example.infrastructure.mappers.EmployeeRequestMapper
import br.com.hexagonal.example.infrastructure.repository.SpringDataEmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class EmployeeService(
    @Autowired val repository: SpringDataEmployeeRepository,
    @Autowired val employMapper: EmployeeRequestMapper,
    val exceptionMessage: String = "Recurso não encontrado"
) : EmployeeRepositoryPort {

    @Transactional
    override fun createEmployee(employeeRequest: EmployeeRequestDTO): Employee {
        return repository.save(employMapper.mapper(employeeRequest))
    }

    override fun getEmployeeById(employeeId: Long): Employee? {
        return repository.findById(employeeId).orElseThrow {
            EmployeeException(exceptionMessage)
        }
    }

    override fun listAllEmployees(): List<Employee> {
        return repository.findAll()
    }

    @Transactional
    override fun updateEmployee(
        employeeId: Long, employeeRequest: EmployeeRequestDTO
    ): Employee? {
        val employee: Optional<Employee> = repository.findById(employeeId)

        if (employee.isPresent) {
            employee.get().name = employeeRequest.name
            employee.get().role = employeeRequest.role
            employee.get().salary = employeeRequest.salary
            return repository.saveAndFlush(employee.get())
        }

        return null
    }

    @Transactional
    override fun removeEmployee(employeeId: Long) {
        val employee = repository.findById(employeeId)
            .orElseThrow { EmployeeException(exceptionMessage) }

        if (Objects.nonNull(employee)) {
            repository.delete(employee)
        }
    }
}
