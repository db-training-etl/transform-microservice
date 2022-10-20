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

    WebClient webClient;
    ObjectMapper objectMapper;
    String baseUrl;

    public TransformService(){
        this.baseUrl = "uri/";
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

        List<Trade> trades = webClient.get()
               .uri("trades")
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
