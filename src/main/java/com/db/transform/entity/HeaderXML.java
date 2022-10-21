package com.db.transform.entity;

import lombok.Data;

@Data
public class HeaderXML {

    private Integer tradeId;

    private String tradeTradeName;

    public void setTradeId(Trade tradeId) {
        this.tradeId = tradeId.getId();
    }

    public void setTradeTradeName(Trade tradeTradeName) {
        this.tradeTradeName = tradeTradeName.getTradeName();
    }




}
