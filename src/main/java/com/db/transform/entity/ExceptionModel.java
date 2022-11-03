package com.db.transform.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ExceptionModel {

    Integer id;
    String name;
    String type;
    String message;
    String trace;
    Date cobDate;

    public ExceptionModel(String name, String type, String message, String trace, Date cobDate) {
        this.name = name;
        this.type = type;
        this.message = message;
        this.trace = trace;
        this.cobDate = cobDate;
    }
}
