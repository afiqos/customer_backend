package com.example.customer_backend.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    val customers: MutableList<Customer> = ArrayList()      // not too sure on why using this

    fun findById(id: Int): Customer? {
        return customerRepository.findById(id).orElse(null)
    }


    fun findAll(): MutableIterable<Customer> {
        return customerRepository.findAll()
    }


//    val jack = Customer(1, "Jack", "Home", "user1", "pass123")
//    var customers: MutableList<Customer> = mutableListOf(jack)
//    fun findById(id: Int): Customer? {
//        return jack
//    }


}