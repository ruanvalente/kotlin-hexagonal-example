package br.com.hexagonal.example.application.ports.respository

import br.com.hexagonal.example.application.ports.domain.Employee
import java.util.Optional

interface EmployeeRepositoryPort {
    fun createEmployee(name: String, role: String, salary: Long): Void

    fun getEmployeeById(employeeId: Long): Employee

    fun listAllEmployees(): List<Employee>

    fun updateEmployee(employee: Employee): Void

    fun removeEmployee(employeeId: Long): Void
}