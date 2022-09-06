package br.com.hexagonal.example.application.ports.domain

import javax.persistence.*

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val role: String,

    @Column(nullable = false)
    val salary: Long
)
