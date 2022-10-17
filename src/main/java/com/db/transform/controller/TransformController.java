package com.db.transform.controller;

import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TransformController {

    @Autowired
    TransformService service;

    @PostMapping(value = "/urlThatHasJson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Trade mapJsonToXMLAndCreateFile(@RequestBody Trade request) throws IOException {
       service.createXMLFile(request);
       return request;
    }

}
