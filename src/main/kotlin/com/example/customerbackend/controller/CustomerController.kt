package com.example.customerbackend.controller

import com.example.customerbackend.services.CustomerService
import com.example.customerbackend.entities.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/customers")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

//    @GetMapping
//    fun findAll(): MutableIterable<Customer> = customerService.findAll()

    @GetMapping("/{customerId}")
    fun findById(@PathVariable customerId: Int): ResponseEntity<Customer> {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.findById(customerId))

    }

    // probably need some kind of validation too
    @PostMapping
    fun addNewCustomer(@RequestBody customer: Customer): ResponseEntity<String> {
        customerService.addNewCustomer(customer)
        return ResponseEntity.status(HttpStatus.OK).body("Process successful, new Customer added.")
    }

    // Do we need some validation for deleting? Seems too easy to have accidental deletes from just using URI
    @DeleteMapping("/{customerId}")
    fun deleteCustomer(@PathVariable customerId: Int) = customerService.deleteCustomer(customerId)

    // Do we need some validation for updating?
    // Seems to be updating existing entries fine without needing customerId/account_nuumber param
    @PutMapping
    fun updateCustomer(@RequestBody customer: Customer) = customerService.updateCustomer(customer)

    @GetMapping
    fun findByName(@RequestParam(value="name") customerName: String): List<String> {
        return customerService.findByName(customerName)
    }

}