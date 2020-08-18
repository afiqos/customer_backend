package com.example.customerbackend.exceptions

class IdAlreadyExistsException(message: String): Exception(message)

class MissingCustomerDetailsException(message: String): Exception(message)