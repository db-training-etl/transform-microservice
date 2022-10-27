package com.db.transform.service;

import com.db.transform.entity.Exception;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionServiceTest {

    ExceptionService exceptionService;
    ObjectMapper objectMapper = new ObjectMapper();
    MockWebServer mockBackEnd = new MockWebServer();
    ResponseEntity<Exception> expectedResponse;

    @BeforeEach
    void setup(){
        exceptionService = new ExceptionService(mockBackEnd.url("/").toString());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","application/json");
        responseHeaders.set("content-length", "200");

        expectedResponse = new ResponseEntity<>(new Exception(), responseHeaders, 200);
    }

    @AfterEach
    void closingMockBackend() throws IOException {
        mockBackEnd.close();
    }

    @Test
    void postException() throws JsonProcessingException {
        //GIVEN
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
                .setResponseCode(200)
        );

        //WHEN
        ResponseEntity<Exception> actual = exceptionService.sendException("1","2","3","4", Date.from(Instant.now()));

        //THEN
        assertEquals(expectedResponse,actual);
    }
}
