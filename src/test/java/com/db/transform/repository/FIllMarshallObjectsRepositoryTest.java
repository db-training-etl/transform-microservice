package com.db.transform.repository;

import com.db.transform.entity.Trade;
import com.db.transform.service.ExceptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static com.db.transform.TestUtils.tradeExample;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FIllMarshallObjectsRepositoryTest {

    @Mock
    ExceptionService exceptionService;

    FillMarshallObjectsRepository fillMarshallObjectsRepository;
    @BeforeEach
    void setup(){
        fillMarshallObjectsRepository = new FillMarshallObjectsRepository(exceptionService);
    }

    @Test
    public void throeExceptionWhenIdOrTradeNameAreNull(){

    }

    @Test
    public void givenADateChangeItToTheCorrectFormat(){
        Trade trade = tradeExample();

        String expected = LocalDate.now().toString();

        String date = fillMarshallObjectsRepository.changeDateFormat(trade);

        assertEquals(expected,date);

    }
}
