package br.com.hexagonal.example.application.ports.ui

import br.com.hexagonal.example.application.ports.domain.Employee
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.Optional
import javax.validation.Valid

interface EmployeeUIPort {
    @GetMapping("")
    fun listAllEmployees():List<Employee>

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable("id") employeeId: Long): Employee

    @PostMapping("")
    fun createEmployee(@RequestBody @Valid employee: Employee): Void

    @PutMapping("/{id}")
    fun updateEmployee(@RequestBody @Valid employee: Employee): Void

    @DeleteMapping("/{id}")
    fun removeEmployee(employeeId: Long): Employee
}