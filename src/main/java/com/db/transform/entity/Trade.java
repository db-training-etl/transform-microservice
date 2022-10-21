package com.db.transform.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JacksonXmlRootElement(localName = "Trade")
public class Trade implements Serializable {

    Integer id;
    String tradeName;
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
