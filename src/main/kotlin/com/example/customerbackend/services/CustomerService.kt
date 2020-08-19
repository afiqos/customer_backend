package com.example.customerbackend.services

import com.example.customerbackend.repositories.CustomerRepository
import com.example.customerbackend.entities.Customer
import com.example.customerbackend.exceptions.IdAlreadyExistsException
import com.example.customerbackend.exceptions.NoIdFoundFromSearchException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    val customers: MutableList<Customer> = ArrayList()      // not too sure on why using this

    fun findById(id: Int): Customer {
        if (customerRepository.existsById(id)) {    // but .orElse will never happen cause we look for existById first
            return customerRepository.findById(id).orElse(null)
        } else {
            throw NoIdFoundFromSearchException("No customer record with matching account number.")
        }
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