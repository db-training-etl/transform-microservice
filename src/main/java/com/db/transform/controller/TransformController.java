package com.db.transform.controller;

import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
public class TransformController {

    @Autowired
    TransformService service;

    @GetMapping(value = "/trades/saveXML")
    public List<Trade> mapJsonToXMLAndCreateFile() throws IOException {
       return service.receiveJsonAndParseToXML();
    }

}
