package com.db.transform.exceptions;

import com.db.transform.controller.TransformController;
import com.db.transform.entity.ChunkTrade;
import com.db.transform.entity.Trade;
import com.db.transform.service.ExceptionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomExceptionHandlerTest {

    CustomExceptionHandler exceptionHandler;
    @Mock
    ExceptionService exceptionService;
    @Mock
    TransformController controller;
    Trade trade;
    MockMvc mockMvc;
    String tradeString;
    String chunkString;
    ObjectMapper mapper;
    ChunkTrade chunkTrade;

    @BeforeEach
    void setup() throws JsonProcessingException {
        exceptionHandler = new CustomExceptionHandler(exceptionService);
        mapper = new ObjectMapper();
        trade = new Trade();
        trade.setId(1);
        tradeString = mapper.writeValueAsString(trade);
        chunkTrade = new ChunkTrade();
        chunkString = mapper.writeValueAsString(chunkTrade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(
                new CustomExceptionHandler(exceptionService)).build();
    }

    @Test
    void failingValidationTradeThrowsBadRequestError() throws Exception {

        mockMvc.perform(post("/trades/save")
                        .content(tradeString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void failingValidationChunkThrowsBadRequestError() throws Exception {

        mockMvc.perform(post("/trades/save/chunk")
                        .content(chunkString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
