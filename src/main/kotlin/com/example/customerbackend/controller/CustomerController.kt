package com.example.customerbackend.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping("/{customerId}")
    fun findById(@PathVariable customerId: Int): Customer? = customerService.findById(customerId)

    @GetMapping
    fun findAll(): MutableIterable<Customer> = customerService.findAll()

}