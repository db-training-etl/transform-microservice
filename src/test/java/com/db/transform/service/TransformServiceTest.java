package com.db.transform.service;

import com.db.transform.TestUtils;
import com.db.transform.entity.Book;
import com.db.transform.entity.Counterparty;
import com.db.transform.entity.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import static com.db.transform.TestUtils.tradeExample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransformServiceTest {

    TransformService service = new TransformService();

    MockWebServer mockWebServer = new MockWebServer();
    @Mock
    ObjectMapper objectMapper;
    Book book;
    @Mock
    TestUtils testUtils;

    Counterparty counterparty;
    String path = "src/test/resources/tradeName-cobdate-test.xml";

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }
    @Disabled //falta hacer el webClient
    @Test
    void getTradesFromWebService() throws IOException {
        //Given
        Trade trade = tradeExample();

        mockWebServer.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(trade))
        );

        //When
       Trade actualTrade = new Trade();

       actualTrade.setId(1);

        //Then
        assertEquals(trade.toString(),actualTrade.getId().toString());
    }

    @Test
    void fileIsCreated() throws IOException, XMLStreamException {

        //Given
        Trade trade = tradeExample();
        File file = new File(path);
        //When
        service.createXMLFile(trade, path);
        //Then
        assertTrue(file.exists());
    }

}
