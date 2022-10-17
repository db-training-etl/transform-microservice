package com.db.transform.service;

import com.db.transform.entity.Trade;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor
public class TransformService {

    public File createXMLFile(Trade request) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File("src/main/resources/tradeName-cobdate.xml"), request);

        return new File("src/main/resources/tradeName-cobdate.xml");
    }


}
