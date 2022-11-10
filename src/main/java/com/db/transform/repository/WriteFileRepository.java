package com.db.transform.repository;

import com.db.transform.entity.TradeWrapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
@Repository
@AllArgsConstructor
public class WriteFileRepository {

    public void formatXML(String path, TradeWrapper wrapper) {

        try {
            FileWriter fw = new FileWriter(path, true);

            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

            mapper.writeValue(fw, wrapper);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
