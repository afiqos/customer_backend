package com.example.customerbackend.entities

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "customers")
data class Customer (
        @Id
        @Column(name = "account_number")  // not sure why if using "accountNumber" it will be defaulted to "account_number" later on
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var accountNumber: Int,

        @field:NotBlank(message = "Customer's name is missing")
        @Column(name = "name")
        var name: String,

        @field:NotBlank(message = "Customer's address is missing")
        @Column(name = "address")
        var address: String,

        @field:NotBlank(message = "Customer's username is missing")
        @Column(name = "username")
        var username: String,

        @field:NotBlank(message = "Customer's password is missing")
        @Column(name = "password")
        var password: String // probably need to be something else? maybe hashed or something
)
{
//        @Id @Column(name = "account_number")
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        var accountNumber: Int = 1
}