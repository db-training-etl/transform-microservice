package com.db.transform.service;

import com.db.transform.entity.Trade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import static com.db.transform.TestUtils.tradeExample;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TransformServiceTest {

    ExceptionService exceptionService = new ExceptionService();
    TransformService service = new TransformService();
    String path = "src/test/resources/tradeName-cobdate-test.xml";

    @Test
    void fileIsCreated() throws IOException, XMLStreamException {

        //Given
        Trade trade = tradeExample();
        File file = new File(path);
        //When
        service.enrichXML(trade, path);
        //Then
        assertTrue(file.exists());
    }
    @Test
    void whenPopulatingHeaderIdOrTradeNameOrBothAreNull(){
        Trade trade1 = new Trade();
        trade1.setId(1);
        trade1.setTradeName("1");

        Trade trade2 = new Trade();
        trade2.setId(1);

        Trade trade3 = new Trade();
        trade3.setTradeName("1");

        service.getHeader(trade1);
        service.getHeader(trade2);
        service.getHeader(trade3);


       verify(service, times(1)).sendException("","","","",null);

    }

}
