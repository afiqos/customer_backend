package com.example.customer_backend.customer

import org.springframework.data.repository.CrudRepository


interface CustomerRepository : CrudRepository<Customer, Int> {

}