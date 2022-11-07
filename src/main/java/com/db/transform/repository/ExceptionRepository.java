package com.db.transform.repository;

import com.db.transform.entity.ExceptionModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class ExceptionRepository implements ExceptionRequest{

    WebClient webClient;
    @Value("${url.exception}")
    String baseUrl;

    public ExceptionRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public ExceptionRepository(String url) {
        webClient = WebClient
                .builder()
                .baseUrl(url)
                .build();
    }
    @Override
    public ResponseEntity<ExceptionModel> postException(ExceptionModel exception) {
        return webClient.post()
                .uri("exceptions")
                .bodyValue(exception)
                .retrieve()
                .toEntity(ExceptionModel.class)
                .block();
    }
}
