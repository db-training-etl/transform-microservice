package com.db.transform.controller;

import com.db.transform.entity.ChunkTrade;
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
    public ResponseEntity<Trade> mapTradeToXMLAndCreateFile(@RequestBody @Valid Trade trade){
        service.enrichXML(trade);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/trades/save/chunk")
    public ResponseEntity<ChunkTrade> mapChunkOfTradesToXMLAndCreateFile(@RequestBody @Valid ChunkTrade chunk){
        service.enrichChunk(chunk);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
