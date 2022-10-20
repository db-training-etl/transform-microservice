package com.db.transform.service;

import com.db.transform.entity.Trade;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TransformServiceTest {

    TransformService service = new TransformService();


    @Test
    void fileIsCreated() throws IOException {

        //Given
        List<Trade> trades = new ArrayList<>();
        File file = new File("src/main/resources/tradeName-cobdate.xml");
        //When
        service.createXMLFile(trades);
        //Then
        assertTrue(file.exists());
    }

    @Test
    void filePathIsCorrect() throws IOException {

        //Given
        List<Trade> trades = new ArrayList<>();
        File file = new File("src/main/resources/tradeName-cobdate.xml");
        //When
        service.createXMLFile(trades);
        //Then
        assertEquals("src\\main\\resources\\tradeName-cobdate.xml", file.getPath());

    }

}
