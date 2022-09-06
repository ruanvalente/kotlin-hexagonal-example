package br.com.hexagonal.example.adapter.controllers

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.ports.domain.Employee
import br.com.hexagonal.example.application.ports.ui.EmployeeUIPort
import br.com.hexagonal.example.application.services.EmployeeService
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Objects

@RestController
@RequestMapping("employees")
class EmployeeControllerAdapter(val employeeService: EmployeeService): EmployeeUIPort {
    override fun listAllEmployees(): List<Employee> {
       return employeeService.listAllEmployees()
    }

    override fun getEmployeeById(employeeId: Long): Employee {
        return employeeService.getEmployeeById(employeeId)
    }

    override fun createEmployee(employeeRequest: EmployeeRequestDTO): Employee {
        return employeeService.createEmployee(employeeRequest)
    }

    override fun removeEmployee(employeeId: Long) {
        employeeService.removeEmployee(employeeId)
    }

}