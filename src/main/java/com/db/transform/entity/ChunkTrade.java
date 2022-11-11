package com.db.transform.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ChunkTrade {

    @NotNull
    private Integer id;

    private Integer numCHunk;

    private List<Trade> trades;

    private Integer numTrades;
}
