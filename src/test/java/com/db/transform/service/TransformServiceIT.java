package com.db.transform.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.test.web.reactive.server.WebTestClient.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class TransformServiceIT {

    @Autowired
    WebTestClient webTestClient;
    @Disabled //Falta por hacer la parte de WebClient
    @Test
    public void ReceiveJsonWithExpectedBodyAndHeaders(){

        //When
        ResponseSpec response = webTestClient.get()
                .uri("/trades/saveXML")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //Then

        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody();
    }
}
