package com.example.customerbackend.aspect

import com.example.customerbackend.exceptions.MissingCustomerDetailsException
import com.example.customerbackend.exceptions.MissingFindByIdParamException
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException

@Aspect
@Component
class CustomerServiceAspect {
    @Pointcut("execution(* com.example.customerbackend.services.CustomerService.addNewCustomer(..))")
    fun addCustomerOperation() {}

    @AfterThrowing("addCustomerOperation()", throwing = "exception")
    fun addCustomerConstraintViolation(exception: ConstraintViolationException) {
        // need to clean this message and get only the interpolated message
        throw MissingCustomerDetailsException(exception.constraintViolations.toString())
    }

    @Pointcut("execution(* com.example.customerbackend.services.CustomerService.findById(..))")
    fun findByIdOperation() {}

    @AfterThrowing("findByIdOperation()", throwing = "exception")
    fun findByIdMissingRequestParam(exception: MissingServletRequestParameterException) {
        throw MissingFindByIdParamException(exception.localizedMessage)
    }

}