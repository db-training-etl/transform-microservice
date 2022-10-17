package com.db.transform.service;

import com.db.transform.entity.Trade;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransformServiceTest {

    TransformService service = new TransformService();

    @Test
    void fileIsCreated() throws IOException {

        //Given
        Trade trade = new Trade();
        File file = new File("src/main/resources/tradeName-cobdate.xml");
        //When
        service.createXMLFile(trade);
        //Then
        assertTrue(file.exists());
    }
    @Disabled
    @Test
    void filePathIsCorrect() throws IOException {

        //Given
        Trade trade = new Trade();
        File file = new File("src/main/resources/tradeName-cobdate.xml");
        //When
        service.createXMLFile(trade);
        //Then
        assertEquals("src\\main\\resources\\tradeName-cobdate.xml", file.getPath());

    }
}
