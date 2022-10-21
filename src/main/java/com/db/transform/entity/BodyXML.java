package com.db.transform.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BodyXML {

    Integer bookId;
    String country;
    Integer counterpartyId;
    String currency;
    Date cobDate;
    Double amount;
    Boolean tradeTax;
    Book book;
    Counterparty counterparty;

    public void setBookId(Trade bookId) {
        this.bookId = bookId.getBookId();
    }

    public void setCountry(Trade country) {
        this.country = country.getCountry();
    }

    public void setCounterpartyId(Trade counterpartyId) {
        this.counterpartyId = counterpartyId.getCounterpartyId();
    }

    public void setCurrency(Trade currency) {
        this.currency = currency.getCurrency();
    }

    public void setCobDate(Trade cobDate) {
        this.cobDate = cobDate.getCobDate();
    }

    public void setAmount(Trade amount) {
        this.amount = amount.getAmount();
    }

    public void setTradeTax(Trade tradeTax) {
        this.tradeTax = tradeTax.getTradeTax();
    }

    public void setBook(Trade book) {
        this.book = book.getBook();
    }

    public void setCounterparty(Trade counterparty) {
        this.counterparty = counterparty.getCounterparty();
    }
}
