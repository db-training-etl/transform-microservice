package com.db.transform.repository;

import com.db.transform.entity.TradeWrapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;


@Repository
@AllArgsConstructor
@NoArgsConstructor
public class WriteFileRepository {

    @Value("${path.loggerpath}")
    String loggerPath;

    Logger logger = LogManager.getLogger(loggerPath);

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

            logger.debug(e.getMessage());
            logger.info("Error at writing into the document");

            System.out.println(e.getMessage());

        }
    }
}
