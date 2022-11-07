package com.db.transform.IT;

import com.db.transform.entity.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;
import java.util.Date;

import static com.db.transform.TestUtils.tradeExample;
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
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void whenJsonConverterIsFoundThenReturnResponse() throws Exception {

        //Given

        String url = "/trades/save";


        Trade trade = tradeExample();
        String content = objectMapper.writeValueAsString(trade);


        //When
        ResultActions response = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content));

        //Then

        response
                .andExpect(status().isOk());
    }


}
