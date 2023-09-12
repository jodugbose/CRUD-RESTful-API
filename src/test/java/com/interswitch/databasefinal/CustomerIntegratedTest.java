package com.interswitch.databasefinal;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CustomerIntegratedTest {
    @Autowired
    private MockMvc mockMvc;
@Test
    //@Sql("/create-tutorial.sql")
    public void testCreateCustomer() throws Exception{
        mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON).content("{\"fullName\": \"Sogo\"," + "\"phoneNumber\": \"09249032092\", "+ "\"dateJoined\": \"12/12/2034\"}")).andExpect(status().isCreated());

    }



}
