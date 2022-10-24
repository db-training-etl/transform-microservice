package com.db.transform.service;

import com.db.transform.entity.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class TransformService {

    WebClient webClient; //Refractorizar en una interficie más adelante
    ObjectMapper objectMapper;
    String baseUrl;

    public TransformService(){
        this.baseUrl = "jsonplaceholder.typicode.com/"; //Cambiarlo cuando esté montado
        webClient = WebClient
                .builder()
                        .baseUrl(baseUrl)
                                .build();
    }

    public TransformService(String baseUrl){
        this.baseUrl = baseUrl;
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List<Trade> receiveJsonAndParseToXML() throws IOException {

        String path = "src/main/resources/tradeName-cobdate.xml";

        List<Trade> trades = webClient.get()
               .uri("users")//Hay que cambiarlo cuando esté montado
               .accept(MediaType.APPLICATION_XML)
               .retrieve()
               .bodyToMono(new ParameterizedTypeReference<List<Trade>>() {})
               .block();

        createXMLFile(trades, path);

        return trades;
    }

    public File createXMLFile(List<Trade> requests, String path) throws IOException {


        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(path), requests);

        return new File(path);
    }


}
