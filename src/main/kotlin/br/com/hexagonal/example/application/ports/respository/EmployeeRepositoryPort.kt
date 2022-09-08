package br.com.hexagonal.example.application.ports.respository

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.ports.domain.Employee

interface EmployeeRepositoryPort {
    fun createEmployee(employeeRequest: EmployeeRequestDTO): Employee

    fun getEmployeeById(employeeId: Long): Employee?

    fun listAllEmployees(): List<Employee>

    fun updateEmployee(employeeId: Long, employeeRequest: Employee): Employee

    fun removeEmployee(employeeId: Long): Employee?
}