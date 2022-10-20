package com.db.transform.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book {

    Integer bookId;
    String bookName;
    String bookAddress;
    String entity;
}
