package com.example.customer_backend.customer

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class Customer (
        @Id
        @Column(name = "account_number")
        var account_number: Int,

        @Column(name = "name")
        var name: String,

        @Column(name = "address")
        var address: String,

        @Column(name = "username")
        var username: String,

        @Column(name = "password")
        var password: String // probably need to be something else?
) {
}