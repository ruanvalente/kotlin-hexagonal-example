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
import java.util.Optional

@Service
class EmployeeService(
    @Autowired
    val repository: SpringDataEmployeeRepository,
    @Autowired
    val employMapper: EmployeeRequestMapper
) :
    EmployeeRepositoryPort {

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
    override fun updateEmployee(employeeId: Long, employeeRequest: Employee) {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun removeEmployee(employeeId: Long) {
        TODO("Not yet implemented")
    }

}
