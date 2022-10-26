package com.db.transform.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "message")
public class Trade {
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