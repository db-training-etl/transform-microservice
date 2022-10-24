package com.db.transform.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.HashMap;

@Service
public class ExceptionService {

    WebClient webClient; //Refractorizar en una interficie más adelante
    String baseUrl;

    public ExceptionService() {
        this.baseUrl = "jsonplaceholder.typicode.com/"; //Cambiarlo cuando esté montado
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public ExceptionService(String baseUrl) {
        this.baseUrl = baseUrl;
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public ResponseEntity<Exception> sendException(String name, String type, String message, String trace, Date cobDate) {

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("type", type);
        requestBody.put("message", message);
        requestBody.put("trace", trace);
        requestBody.put("cobDate", cobDate);

        return webClient.post()
                .uri("users")//Hay que cambiarlo cuando esté montado
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .toEntity(Exception.class)
                .block();

    }
}