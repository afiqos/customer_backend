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
@WebMvcTest(CustomerController::class)

//@SpringBootTest
//@AutoConfigureMockMvc

//@Sql("/schema-test.sql", "/import.sql")
internal class CustomerControllerTest {

    @TestConfiguration
    class CustomerControllerTestConfig {
        @Bean
        fun customerService() = mockk<CustomerService>(relaxed = true)

        @Bean
        fun CustomerRepository() = mockk<CustomerRepository>()
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var customerService: CustomerService

    @Test
    internal fun springContextLoaded() {

    }

    private val gson = Gson()

    @Test
    internal fun checkDbEmpty() {   // ensuring that DB is not initialized with values for the controller unit tests
        val testCustomerId = 1
        val expectedResult = Customer(0,"", "", "", "")

        mockMvc.perform(MockMvcRequestBuilders
                .get("/customers/{customerId}", testCustomerId)
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk)       // should change
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(gson.toJson(expectedResult)))
                .andDo(print())
    }

    @Test
    internal fun findById() {
        val testCustomerId = 1
        val mockFoundCustomer = Customer(1, "ttt", "Homeee", "user111", "pass111")

        every { customerService.findById(testCustomerId) } returns mockFoundCustomer

        mockMvc.perform(MockMvcRequestBuilders
                .get("/customers/{customerId}", testCustomerId)
                .accept(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(gson.toJson(mockFoundCustomer)))
    }

    @Test
    internal fun addNewCustomerSuccessResponse() {
        val mockedOutput = Customer(1, "", "Homeee", "user111", "pass111")

//        every { customerService.addNewCustomer(mockedOutput) } returns Unit     // whats the point of this? still works with or w/o it

        mockMvc.perform(MockMvcRequestBuilders
                .post("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(mockedOutput)))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Process successful, new Customer added."))
    }

/*
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

    @Test
    internal fun testAddNewCust() {
        val testPostContent = Customer(0,"yyyuuue", "Home", "user111", "pass111")

         mockMvc.perform(MockMvcRequestBuilders
                 .post("/customers")
                 .accept(MediaType.APPLICATION_JSON)
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(gson.toJson(testPostContent)))

                 .andExpect(status().isOk)
                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(content().string("Process successful, new Customer added."))

    }

    @Test
    internal fun testAddNewCustWithExistingAccountNumber() {
        val testPostContent = Customer(1, "fdasfdas", "homie", "user1", "pass1")

        mockMvc.perform(MockMvcRequestBuilders
                .post("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(testPostContent)))

                .andExpect(status().isOk)   // should it still be isOk? considering we want the POST to fail
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Account Number already exists. Process cancelled."))
    }
 */

}