package com.db.transform.controller;

import com.db.transform.entity.RequestModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONToXMLMappingController {

    @PostMapping(path = "/mapJsontoXML", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody RequestModel mapJsonToXML(@RequestBody final RequestModel request) {
        return request;
    }
}
