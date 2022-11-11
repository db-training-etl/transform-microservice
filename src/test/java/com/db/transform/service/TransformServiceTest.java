package com.db.transform.service;

import com.db.transform.entity.Trade;
import com.db.transform.repository.FillMarshallObjectsRepository;
import com.db.transform.repository.WriteFileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.db.transform.TestUtils.tradeExample;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransformServiceTest {

    TransformService service;

    @Mock
    FillMarshallObjectsRepository fillMarshallObjectsRepository;

    @Mock
    WriteFileRepository writeFileRepository;

    String path = "src/test/resources/tradeName-cobdate-test.xml";


    @BeforeEach
    public void setup(){
        service = new TransformService(writeFileRepository,fillMarshallObjectsRepository,path);
    }

    @Test
    public void whenTradeReceivedCallFunctions(){

        Trade trade = tradeExample();

        service.enrichXML(trade);

        verify(writeFileRepository, times(1)).formatXML(eq(path),any());
        verify(fillMarshallObjectsRepository, times(1)).getBody(trade);
        verify(fillMarshallObjectsRepository, times(1)).getHeader(trade);
    }

}
