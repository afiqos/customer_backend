package com.example.customerbackend.customer

import org.springframework.data.repository.CrudRepository


interface CustomerRepository : CrudRepository<Customer, Int> {

}