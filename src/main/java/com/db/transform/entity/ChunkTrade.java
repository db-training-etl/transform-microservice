package com.db.transform.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChunkTrade {

    private int id;
    private int numCHunk;;
    private List<Trade> trades;
    private int numTrades;
}
