package com.db.transform.IT;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.test.web.reactive.server.WebTestClient.*;

@SpringBootTest
@AutoConfigureWebTestClient
@Disabled
public class ExceptionModelServiceIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void ReceiveJsonWithExpectedBodyAndHeaders(){

        //When
        ResponseSpec response = webTestClient.post()
                .uri("exceptions")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //Then

        response.expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody();
    }
}
