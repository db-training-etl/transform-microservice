package com.db.transform.controller;

import com.db.transform.entity.Book;
import com.db.transform.entity.Counterparty;
import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TransformControllerTest {

    TransformService service;
    TransformController controller;
    Book book;
    Trade trade;
    Counterparty counterparty;
    List<Trade> trades;

    @BeforeEach
    void setup(){
        service = mock(TransformService.class);
        controller = new TransformController(service);



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
    void whenJsonReceivedTransformIntoXML() throws Exception {

        //Given
        XmlMapper xmlMapper = new XmlMapper();
        System.out.println(trades.get(0));
        System.out.println(controller.mapJsonToXMLAndCreateFile());
        //When
        given(service.receiveJsonAndParseToXML()).willReturn(trades);
        String tradeXMLExpected = xmlMapper.writeValueAsString(trades);
        String tradeXMLActual = xmlMapper.writeValueAsString(controller.mapJsonToXMLAndCreateFile());
        //Then
        Assertions.assertEquals(tradeXMLExpected, tradeXMLActual);
    }

}
