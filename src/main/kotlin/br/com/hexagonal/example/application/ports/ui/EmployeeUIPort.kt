package br.com.hexagonal.example.application.ports.ui

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

interface EmployeeUIPort {
    @GetMapping("list")
    fun listAllEmployees(): ResponseEntity<List<Employee>>

    @GetMapping("/view/{id}")
    fun getEmployeeById(@PathVariable("id") employeeId: Long):
            ResponseEntity<Employee>

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEmployee(@RequestBody @Valid employeeRequest:
                       EmployeeRequestDTO, uriBuilder: UriComponentsBuilder):
            ResponseEntity<Employee>
//
//    @PutMapping("/update/{id}")
//    fun updateEmployee(@RequestBody @Valid employee: Employee): Void
//
    @DeleteMapping("/remove/{id}")
    fun removeEmployee(@PathVariable("id") employeeId: Long):
        ResponseEntity<Employee>
}