package com.example.customerbackend.exceptions

import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

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

    @ExceptionHandler(NoIdFoundFromSearchException::class)
    fun handleException(noIdFoundFromSearchException: NoIdFoundFromSearchException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK)     // chose OK status cause the request was successful but just no record found (or should use NO CONTENT instead?)
                .body(noIdFoundFromSearchException.message)
    }

    @ExceptionHandler(UpdateIdDoesNotExistException::class)
    fun handleException(updateIdDoesNotExistException: UpdateIdDoesNotExistException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(updateIdDoesNotExistException.message)
    }

    @ExceptionHandler(DeleteIdDoestNotExistException::class)
    fun handleException(deleteIdDoestNotExistException: DeleteIdDoestNotExistException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(deleteIdDoestNotExistException.message)
    }

//    @ExceptionHandler(MissingFindByIdParamException::class)
//    fun handleException(missingFindByIdParamException: MissingFindByIdParamException,
//        headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
////        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
////                .body(missingFindByIdParamException.message)
//
//        return super.handleMissingServletRequestParameter(missingFindByIdParamException., headers, status, request)
//    }

//    @ExceptionHandler(MissingFindByIdParamException::class)
//    fun handleFindByIdMissingParamException(exception: MissingServletRequestParameterException,
//                        headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
//    //        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//    //                .body(missingFindByIdParamException.message)
//        exception.message =
//
//        return super.handleMissingServletRequestParameter(exception, headers, status, request)
//    }

    /*
        We override this exception handler method that is invoked by default when
            the findById GET request is missing the parameter. And fit it with an appropriate error message.

     */
    @ExceptionHandler(MissingFindByIdParamException::class)
    override fun handleMissingServletRequestParameter(exception: MissingServletRequestParameterException,
                                                      headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {

        // using custom message as default message "Required String parameter 'name' is not present" seems inaccurate
        val message = "Required parameter 'account_number' is not present."

        return ResponseEntity.status(status)
                .body(message)
    }



}