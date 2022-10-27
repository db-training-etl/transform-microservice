package com.db.transform.controller;

import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class TransformController {

    @Autowired
    TransformService service;

    @PostMapping(value = "/trades/save")
    public ResponseEntity<Trade> mapJsonToXMLAndCreateFile(@RequestBody Trade trade) throws IOException, XMLStreamException {
        service.enrichXML(trade,"src/test/resources/tradeName-cobdate-test.xml");
       return new ResponseEntity<>(trade, HttpStatus.OK);
    }

}
