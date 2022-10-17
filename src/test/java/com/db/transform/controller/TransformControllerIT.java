package com.db.transform.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransformControllerIT {
    @Autowired
    MockMvc mockMvc;

   /*
    @Test
    public void whenJsonConverterIsFoundThenReturnResponse() throws Exception {

        //Given
        String url = "http://localhost:8080/mapJsontoXML";

        String xml = "";

        String json = "";
        // When
        this.mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))

                //Then
                .andExpect(status().isOk())
                .andExpect(content().xml(xml));
    }
    */
    
}
