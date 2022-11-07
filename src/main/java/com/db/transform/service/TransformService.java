package com.db.transform.service;

import com.db.transform.entity.Body;
import com.db.transform.entity.Header;
import com.db.transform.entity.Trade;
import com.db.transform.entity.TradeWrapper;
import com.db.transform.repository.ExceptionRequest;
import com.db.transform.repository.FillMarshallObjectsRepository;
import com.db.transform.repository.WriteFileRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TransformService {

    ExceptionRequest exceptionRequest;
    ExceptionService exceptionService = new ExceptionService(exceptionRequest);
    WriteFileRepository writeFileRepository = new WriteFileRepository();
    FillMarshallObjectsRepository fillMarshallObjectsRepository = new FillMarshallObjectsRepository(exceptionService);
    @Value("${path.testfilepath}")
    String path;

    public void enrichXML(Trade request) {

            Header header = fillMarshallObjectsRepository.getHeader(request);

            Body body = fillMarshallObjectsRepository.getBody(request);

            TradeWrapper wrapper = new TradeWrapper(header, body);

            writeFileRepository.formatXML(path, wrapper);

    }
}
