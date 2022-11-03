package com.db.transform.controllerTest;

import com.db.transform.controller.TransformController;
import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static com.db.transform.TestUtils.tradeExample;

public class TransformControllerTest {

    @Mock
    TransformService service;
    TransformController controller;

    @BeforeEach
    public void setup(){
        controller = new TransformController(service);
    }

    @Test
    void whenJsonReceivedTransformIntoXML() throws Exception {

        //Given
        XmlMapper xmlMapper = new XmlMapper();
        Trade trade = tradeExample();
        //When
        String tradeXMLExpected = xmlMapper.writeValueAsString(trade);
        String tradeXMLActual = xmlMapper.writeValueAsString(controller.mapJsonToXMLAndCreateFile(trade).getBody());
        //Then
        Assertions.assertEquals(tradeXMLExpected, tradeXMLActual);
    }

}
