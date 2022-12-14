package com.db.transform.service;

import com.db.transform.entity.ExceptionModel;
import com.db.transform.repository.ExceptionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionServiceTest {

    ExceptionService exceptionService;
    ExceptionRepository exceptionRepository;
    ObjectMapper objectMapper;
    MockWebServer mockBackEnd;
    ResponseEntity<ExceptionModel> expectedResponse;

    @BeforeEach
    void setUp(){
        mockBackEnd = new MockWebServer();
        objectMapper = new ObjectMapper();
        exceptionRepository = new ExceptionRepository(mockBackEnd.url("/").url().toString());
        exceptionService = new ExceptionService(exceptionRepository);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","application/json");
        responseHeaders.set("content-length","200");

        expectedResponse = new ResponseEntity<>(new ExceptionModel(), responseHeaders, 200);


    }

    @Test
    void postException() throws JsonProcessingException {
        //GIVEN
        mockBackEnd.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(expectedResponse))
        );

        ExceptionModel exception = ExceptionModel.builder()
                .name("name")
                .type("name")
                .message("message")
                .trace("trace")
                .cobDate(Date.from(Instant.now()))
                .build();

        //WHEN
        ResponseEntity<ExceptionModel> actual = exceptionService.sendException(exception);

        //THEN
        assertEquals(expectedResponse.toString(),actual.toString());
    }
}
