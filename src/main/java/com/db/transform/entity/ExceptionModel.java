package com.db.transform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionModel {

    Integer id;
    String name;
    String type;
    String message;
    String trace;
    Date cobDate;
}
