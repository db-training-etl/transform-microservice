package com.db.transform.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ChunkTrade {

    @NotNull
    private Integer processId;

    private Integer numChunks;

    private Integer size;

    private List<Trade> data;
}
