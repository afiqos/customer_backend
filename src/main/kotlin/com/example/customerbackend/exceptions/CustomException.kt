package com.example.customerbackend.exceptions

class MissingCustomerDetailsException(message: String): Exception(message)

class NoIdFoundFromSearchException(message: String): Exception(message)

class IdAlreadyExistsException(message: String): Exception(message)

class MissingFindByIdParamException(message: String): Exception(message)

class UpdateIdDoesNotExistException(message: String): Exception(message)