package com.db.transform.controller;

import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class TransformControllerIT {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransformService service;

    @Test
    public void whenJsonConverterIsFoundThenReturnResponse() throws Exception {

        //Given

        String url = "/trades";

        List<Trade> trades = new ArrayList<>();

        Trade trade = new Trade();

        trade.setId(1);

        trades.add(trade);

        //When

        given(service.receiveJsonAndParseToXML()).willReturn(trades);
        ResultActions response = mockMvc.perform(get(url));

        //Then

        response
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].id", is(1)));
    }


}
