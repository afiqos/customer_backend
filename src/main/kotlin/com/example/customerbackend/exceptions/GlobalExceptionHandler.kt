package com.example.customerbackend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IdAlreadyExistsException::class)
    fun handleException(idAlreadyExistsException: IdAlreadyExistsException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(idAlreadyExistsException.message)
    }

    @ExceptionHandler(MissingCustomerDetailsException::class)
    fun handleException(missingCustomerDetailsException: MissingCustomerDetailsException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(missingCustomerDetailsException.message)
    }

}