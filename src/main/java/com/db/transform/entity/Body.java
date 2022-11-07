package com.db.transform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Body {

    Integer bookId;
    String country;
    Integer counterpartyId;
    String currency;
    Date cobDate;
    Double amount;
    Boolean tradeTax;
    Book book;
    Counterparty counterparty;
}
