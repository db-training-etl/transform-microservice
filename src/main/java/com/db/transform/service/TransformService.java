package com.db.transform.service;

import com.db.transform.entity.Body;
import com.db.transform.entity.Header;
import com.db.transform.entity.Trade;
import com.db.transform.entity.TradeWrapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.time.Instant;
import java.util.Date;

@Service
@NoArgsConstructor
public class TransformService {
    ExceptionService exceptionService = new ExceptionService();

    public void enrichXML(Trade request, String path) throws IOException, XMLStreamException {

            Header header = getHeader(request);

            Body body = getBody(request);

            TradeWrapper wrapper = new TradeWrapper(header, body);

            formatXML(path, wrapper);


    }

    public void formatXML(String path, TradeWrapper wrapper) throws XMLStreamException, IOException {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        XMLStreamWriter sw = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(path, true));

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        mapper.writeValue(sw, wrapper);

        sw.flush();
        sw.close();
    }

    public Body getBody(Trade request) {
        return new Body(request.getBookId(), request.getCountry(), request.getCounterpartyId(), request.getCurrency(),
                request.getCobDate(), request.getAmount(), request.getTradeTax(), request.getBook(), request.getCounterparty());


    }

    public Header getHeader(Trade request){
        try {
            return new Header(request.getId(), request.getTradeName());
        }catch (NullPointerException e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sendException("NullPointerException","NullPointerException",e.getMessage(), sw.toString(),Date.from(Instant.now()));
            throw new NullPointerException(e.getMessage());
        }
    }

        public void sendException(String name,String type, String message,String trace, Date cobDate){
            exceptionService.sendException(name,type,message,trace,cobDate);
    }

}
