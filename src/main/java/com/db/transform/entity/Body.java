package com.db.transform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Body {

    Integer bookId;
    String country;
    Integer counterpartyId;
    String currency;
    String cobDate;
    Double amount;
    Boolean tradeTax;
    Book book;
    Counterparty counterparty;
}
