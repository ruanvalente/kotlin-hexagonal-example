package br.com.hexagonal.example.adapters.controllers

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.ports.domain.Employee
import br.com.hexagonal.example.application.ports.ui.EmployeeUIPort
import br.com.hexagonal.example.application.services.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("employees")
class EmployeeControllerAdapter(val employeeService: EmployeeService) :
    EmployeeUIPort {
    override fun listAllEmployees(): ResponseEntity<List<Employee>> {
        return ResponseEntity.ok().body(employeeService.listAllEmployees())
    }

    override fun getEmployeeById(employeeId: Long): ResponseEntity<Employee> {
        val employee = employeeService.getEmployeeById(employeeId)
        return ResponseEntity.ok().body(employee)
    }

    override fun createEmployee(
        employeeRequest: EmployeeRequestDTO, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Employee> {
        val employee = employeeService.createEmployee(employeeRequest)

        val uri: URI =
            uriBuilder.path("/employees/{id}").buildAndExpand(employee.id)
                .toUri()

        return ResponseEntity.created(uri).body((employee))
    }

    override fun updateEmployee(
        employeeId: Long, employeeRequest: EmployeeRequestDTO
    ): ResponseEntity<Employee> {
        val employee =
            employeeService.updateEmployee(employeeId, employeeRequest)

        return ResponseEntity.ok().body(employee)
    }

    override fun removeEmployee(employeeId: Long) {
        employeeService.removeEmployee(employeeId)
    }
}