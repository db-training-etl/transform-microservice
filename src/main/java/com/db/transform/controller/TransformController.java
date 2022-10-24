package com.db.transform.controller;

import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
public class TransformController {

    @Autowired
    TransformService service;

    @PostMapping(value = "/trades/saveXML")
    public ResponseEntity<List<Trade>> mapJsonToXMLAndCreateFile(@RequestBody List<Trade> trades) throws IOException {
        service.createXMLFile(trades,"src/test/resources/tradeName-cobdate-test.xml");
       return new ResponseEntity<>(trades, HttpStatus.OK);
               //service.receiveJsonAndParseToXML(trades);
    }

}
