package com.db.transform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header {
    @NonNull
    private  Integer id;
    @NonNull
    private String tradeName;
}
