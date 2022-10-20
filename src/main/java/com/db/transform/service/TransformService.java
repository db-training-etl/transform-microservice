package com.db.transform.service;

import com.db.transform.entity.Trade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.netty.resolver.DefaultAddressResolverGroup;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransformService {

    WebClient webClient;
    ObjectMapper objectMapper;

    public TransformService(){
        webClient = WebClient
                .builder()
                        .baseUrl("jsonplaceholder.typicode.com/")
                                .build();
    }

    public List<Trade> receiveJsonAndParseToXML() throws IOException {

        List<Trade> trades = webClient.get()
               .uri("users")
               .accept(MediaType.APPLICATION_XML)
               .retrieve()
               .bodyToMono(new ParameterizedTypeReference<List<Trade>>() {})
               .block();

        createXMLFile(trades);

        return trades;
    }

    public File createXMLFile(List<Trade> requests) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File("src/main/resources/tradeName-cobdate.xml"), requests);

        return new File("src/main/resources/tradeName-cobdate.xml");
    }


}
