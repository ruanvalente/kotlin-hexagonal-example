package br.com.hexagonal.example.infrastructure.mappers

interface Mapper<T, D> {
    fun mapper(t: T): D
}