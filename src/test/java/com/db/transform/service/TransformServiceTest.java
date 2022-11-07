package com.db.transform.service;

import com.db.transform.entity.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

import static com.db.transform.TestUtils.tradeExample;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TransformServiceTest {

    TransformService service;

    @Mock
    ExceptionService exceptionService;
    @Value("${path.testfilepath}")
    String path;


    @BeforeEach
    public void setup(){
        service = new TransformService();
    }



}
