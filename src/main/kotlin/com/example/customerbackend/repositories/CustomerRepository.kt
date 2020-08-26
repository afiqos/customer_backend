package com.example.customerbackend.repositories

import com.example.customerbackend.entities.Customer
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param


interface CustomerRepository : CrudRepository<Customer, Int> {
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    fun findByNameLike(@Param("name") customerName: String): MutableList<Customer>
}
