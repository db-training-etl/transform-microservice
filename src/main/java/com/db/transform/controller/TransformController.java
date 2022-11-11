package com.db.transform.controller;

import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class TransformController {
    TransformService service;
    @PostMapping(value = "/trades/save")
    public ResponseEntity<Trade> mapJsonToXMLAndCreateFile(@RequestBody @Valid Trade trade){
        service.enrichXML(trade);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/trades/filter/list")
    public ResponseEntity<ChunckTrade> postFilterList(@RequestBody @Valid ChunckTrade chunk){
        service.enrichChunk(chunk);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
