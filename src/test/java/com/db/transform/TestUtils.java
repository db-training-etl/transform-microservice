package com.db.transform;

import com.db.transform.controller.TransformController;
import com.db.transform.entity.Book;
import com.db.transform.entity.Counterparty;
import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Mockito.mock;

public class TestUtils {

    TransformService service;
    TransformController controller;
    static Book book;
    Trade trade;
    static Counterparty counterparty;

    public static Trade tradeExample(){

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

        return trade;
    }
}