package br.com.hexagonal.example.application.ports.ui

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.DTO.responses.EmployeeResponseDTO
import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.Optional
import javax.validation.Valid

interface EmployeeUIPort {
    @GetMapping("list")
    fun listAllEmployees():List<Employee>

    @GetMapping("/view/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getEmployeeById(@PathVariable("id") employeeId: Long): Employee

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEmployee(@RequestBody @Valid employeeRequest:
                       EmployeeRequestDTO): Employee
//
//    @PutMapping("/update/{id}")
//    fun updateEmployee(@RequestBody @Valid employee: Employee): Void
//
    @DeleteMapping("/remove/{id}")
    fun removeEmployee(employeeId: Long)
}