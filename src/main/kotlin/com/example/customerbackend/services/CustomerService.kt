package com.example.customerbackend.services

import com.example.customerbackend.repositories.CustomerRepository
import com.example.customerbackend.entities.Customer
import com.example.customerbackend.exceptions.IdAlreadyExistsException
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

    fun addNewCustomer(customer: Customer) {
        if (customerRepository.existsById(customer.accountNumber)) {
            throw IdAlreadyExistsException("Account Number already exists. Process cancelled.")

        } else {
            customerRepository.save(customer)

        }

    }

    fun deleteCustomer(customerId: Int) {
        customerRepository.deleteById(customerId)
    }

    fun updateCustomer(customer: Customer) {
        customerRepository.save(customer)
    }

    fun findByName(customerName: String): List<String> {
        return customerRepository.findByNameLike(customerName)
    }


}