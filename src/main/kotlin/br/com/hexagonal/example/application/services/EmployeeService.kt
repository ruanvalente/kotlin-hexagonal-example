package br.com.hexagonal.example.application.services

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.ports.domain.Employee
import br.com.hexagonal.example.application.ports.respository.EmployeeRepositoryPort
import br.com.hexagonal.example.infrastructure.mappers.EmployeeRequestMapper
import br.com.hexagonal.example.infrastructure.repository.SpringDataEmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class EmployeeService(
    @Autowired val repository: SpringDataEmployeeRepository,
    @Autowired val employMapper: EmployeeRequestMapper
) : EmployeeRepositoryPort {

    @Transactional
    override fun createEmployee(employeeRequest: EmployeeRequestDTO): Employee {
        return repository.save(employMapper.mapper(employeeRequest))
    }

    override fun getEmployeeById(employeeId: Long): Employee? {
        val employee: Optional<Employee> = repository.findById(employeeId)

        if (employee.isPresent) {
            return employee.get()
        }

        return null
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
    override fun removeEmployee(employeeId: Long): Employee? {
        val employee: Optional<Employee> = repository.findById(employeeId)

        if (employee.isPresent) {
            repository.delete(employee.get())
            return employee.get()
        }

        return null
    }
}
