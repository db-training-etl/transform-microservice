package com.db.transform.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement(localName = "message")
public class TradeWrapper {
    private Header header;
    private Body body;

}
