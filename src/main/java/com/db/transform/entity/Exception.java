package com.db.transform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Exception {

    Integer id;
    String name;
    String type;
    String message;
    String trace;
    Date cobDate;

    public Exception(String name, String type, String message, String trace, Date cobDate) {
        this.name = name;
        this.type = type;
        this.message = message;
        this.trace = trace;
        this.cobDate = cobDate;
    }
}
