package com.db.transform.service;

import com.db.transform.entity.Trade;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

@Service
@NoArgsConstructor
public class TransformService {

    public void createXMLFile(Trade request, String path) throws IOException, XMLStreamException {

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        XMLStreamWriter sw = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(path,true));

        XmlMapper mapper = new XmlMapper();
        sw.writeStartDocument();
        sw.writeStartElement("a");
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        mapper.writeValue(sw,request);


    }

}
