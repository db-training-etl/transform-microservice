package com.db.transform.service;

import com.db.transform.entity.Book;
import com.db.transform.entity.Counterparty;
import com.db.transform.entity.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransformServiceTest {

    TransformService service;
    MockWebServer mockWebServer;
    ObjectMapper objectMapper;
    Book book;
    Trade trade;
    Counterparty counterparty;
    List<Trade> trades;

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    void initialize() throws IOException {

        mockWebServer = new MockWebServer();

        objectMapper = new ObjectMapper();

        service = new TransformService(mockWebServer.url("/").url().toString());

        book = new Book();
        book.setBookId(3);
        book.setEntity("BookEntity");
        book.setBookName("BookName");
        book.setBookAddress("Spain");

        counterparty = new Counterparty();
        counterparty.setCounterpartyId(2);
        counterparty.setEntity("CounterpartyEntity");
        counterparty.setCounterpartyName("Vodafone");
        counterparty.setSource("Google");

        Trade trade = new Trade();
        trade.setId(1);
        trade.setTradeName("TradeName");
        trade.setBookId(book.getBookId());
        trade.setCountry("Jspan");
        trade.setCounterpartyId(counterparty.getCounterpartyId());
        trade.setCurrency("$");
        trade.setCobDate(Date.from(Instant.now()));
        trade.setAmount(1000.0);
        trade.setTradeTax(true);
        trade.setBook(book);
        trade.setCounterparty(counterparty);

        trades = new ArrayList<>();
        trades.add(trade);

    }

    @Test
    void getTradesFromWebService() throws IOException {
        //Given
        mockWebServer.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json")
                .setBody(objectMapper.writeValueAsString(trades))
        );

        //When
        List<Trade> actualTrades = service.receiveJsonAndParseToXML();
        actualTrades.add(trade);

        //Then
        assertEquals(trades.get(0).toString(),actualTrades.get(0).toString());
    }

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
