package com.db.transform.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Counterparty{

    Integer counterpartyId;
    String counterpartyName;
    String source;
    String entity;
}