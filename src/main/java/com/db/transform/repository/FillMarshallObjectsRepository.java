package com.db.transform.repository;

import com.db.transform.entity.Body;
import com.db.transform.entity.ExceptionModel;
import com.db.transform.entity.Header;
import com.db.transform.entity.Trade;
import com.db.transform.service.ExceptionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
@Repository
@AllArgsConstructor
public class FillMarshallObjectsRepository {

    ExceptionService exceptionService;

    public Body getBody(Trade request) {
        return new Body(request.getBookId(), request.getCountry(), request.getCounterpartyId(), request.getCurrency(),
                changeDateFormat(request), request.getAmount(), request.getTradeTax(), request.getBook(), request.getCounterparty());


    }

    private String changeDateFormat(Trade request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return dateFormat.format(request.getCobDate());
    }

    public Header getHeader(Trade request){

        Header header = new Header();
        try {
            header.setId(request.getId());
            header.setTradeName(request.getTradeName());
            return header;
        }catch (NullPointerException e){
            ExceptionModel exceptionModel = new ExceptionModel("NullPointerException","NullPointerException",e.getMessage(), ExceptionUtils.getStackTrace(e), Date.from(Instant.now()));
            exceptionService.sendException(exceptionModel);
            throw new NullPointerException(e.getMessage());
        }
    }
}
