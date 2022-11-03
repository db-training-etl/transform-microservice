package com.db.transform.serviceTest;

import com.db.transform.entity.Trade;
import com.db.transform.service.ExceptionService;
import com.db.transform.service.TransformService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

import static com.db.transform.TestUtils.tradeExample;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class TransformServiceTest {

    TransformService service;

    @Mock
    ExceptionService exceptionService;
    String path = "src/test/resources/tradeName-cobdate-test.xml";


    @BeforeEach
    public void setup(){
        service = new TransformService();
    }
    @Test
    void fileIsCreated() throws IOException, XMLStreamException {

        //Given
        Trade trade = tradeExample();
        File file = new File(path);
        //When

        //Then
        assertTrue(file.exists());
    }
    @Test
    void whenPopulatingHeaderIdOrTradeNameOrBothAreNullThrowException(){

        Trade trade1 = new Trade();

        Trade trade2 = new Trade();
        trade2.setId(1);

        Trade trade3 = new Trade();
        trade3.setTradeName("1");





    }

    @Test
    void sendExceptionMethodIsCalled(){


    }

}
