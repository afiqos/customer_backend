package com.example.customerbackend.aspect

import com.example.customerbackend.exceptions.MissingCustomerDetailsException
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException

@Aspect
@Component
class CustomerServiceAspect {
    @Pointcut("execution(* com.example.customerbackend.services.CustomerService.addNewCustomer(..))")
    fun addCustomerOperation() {}

    @AfterThrowing("addCustomerOperation()", throwing = "exception")
    fun test2(exception: ConstraintViolationException) {
        // need to clean this message and get only the interpolated message
        throw MissingCustomerDetailsException(exception.constraintViolations.toString())

    }


//    @AfterThrowing("addCustomerOperation()")
//    fun test() {
//        throw IdAlreadyExistsException("From AOP validator")
//    }

}