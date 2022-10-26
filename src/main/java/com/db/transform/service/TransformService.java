package com.db.transform.service;

import com.db.transform.entity.Body;
import com.db.transform.entity.Header;
import com.db.transform.entity.Trade;
import com.db.transform.entity.TradeWrapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class TransformService {
    public void createXMLFile(Trade request, String path) throws IOException, XMLStreamException {

        Header header = getHeader(request);

        Body body = getBody(request);

        TradeWrapper wrapper = new TradeWrapper(header,body);

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        XMLStreamWriter sw = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(path,true));

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );

        mapper.writeValue(sw,wrapper);

        sw.flush();
        sw.close();



    }

    private static Body getBody(Trade request) {
        return new Body(request.getBookId(), request.getCountry(), request.getCounterpartyId(), request.getCurrency(),
                request.getCobDate(), request.getAmount(), request.getTradeTax(), request.getBook(), request.getCounterparty());


    }

    private Header getHeader(Trade request){
        return new Header(request.getId(), request.getTradeName());
    }

}
