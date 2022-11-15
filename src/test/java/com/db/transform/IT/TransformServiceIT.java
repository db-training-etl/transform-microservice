package com.db.transform.IT;

import com.db.transform.entity.Trade;
import com.db.transform.service.TransformService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static com.db.transform.TestUtils.tradeExample;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TransformServiceIT {

    @Autowired
    TransformService service;
    @Value("${path.testfilepath}")
    String path;

    @Test
    void fileIsCreated() {

        //Given
        Trade trade = tradeExample();
        File file = new File(path);
        //When
        service.enrichXML(trade);
        //Then
        assertTrue(file.exists());
    }
}
