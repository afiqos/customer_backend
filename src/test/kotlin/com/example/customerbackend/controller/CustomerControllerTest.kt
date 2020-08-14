package com.example.customerbackend.controller

import com.example.customerbackend.entities.Customer
import com.example.customerbackend.repositories.CustomerRepository
import com.example.customerbackend.services.CustomerService
import com.google.gson.Gson
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import javax.print.attribute.standard.Media

@ExtendWith(SpringExtension::class)
//@WebMvcTest(CustomerController::class)
@SpringBootTest
@AutoConfigureMockMvc
//@Sql("/schema-test.sql", "/import.sql")
internal class CustomerControllerTest {

//    @TestConfiguration
//    class CustomerControllerTestConfig {
//        @Bean
//        fun customerService() = mockk<CustomerService>(relaxed = true)
//
//        @Bean
//        fun CustomerRepository() = mockk<CustomerRepository>()
//    }

    @Autowired
    private lateinit var mockMvc: MockMvc

//    @Autowired
//    private lateinit var customerService: CustomerService

    private var customerService = mockk<CustomerService>()
    private var customerRepository = mockk<CustomerRepository>()

    @Test
    internal fun springContextLoaded() {

    }

    val gson = Gson()

    @Test
    internal fun testFindById() {

        val testCustomerId = 1
//        val expectedResult = Customer(1, "Wrong name", "Homeee", "user111", "pass111")
        val expectedResult = Customer(1,"Jack", "Home", "user111", "pass111")

//        every { customerService.findById(testCustomerId) } returns expectedResult

        val result = mockMvc.perform(MockMvcRequestBuilders
                .get("/customers/{customerId}", testCustomerId)
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(gson.toJson(expectedResult)))
//                .andDo(print())
//                .andReturn()

//        print("kkkk " + result.response.contentAsString)
//        assertEquals(gson.toJson(expectedResult), result.response.contentAsString)
    }

    @Test
    internal fun testFindByName() {

        val testSearchName = "Jack"
        val expectedResult = listOf("\"Jack\"", "\"Jacko TTsT\"", "\"aJack TTsT\"")

        mockMvc.perform(MockMvcRequestBuilders
                .get("/customers")
                .param("name", testSearchName))

                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedResult.toString()))
    }
}