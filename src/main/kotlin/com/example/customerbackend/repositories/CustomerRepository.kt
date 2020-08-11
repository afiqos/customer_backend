package com.example.customerbackend.repositories

import com.example.customerbackend.entities.Customer
import org.springframework.data.repository.CrudRepository


interface CustomerRepository : CrudRepository<Customer, Int> {

}