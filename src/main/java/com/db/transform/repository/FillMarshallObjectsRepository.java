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

        return Body.builder()

                .bookId(request.getBookId())
                .country(request.getCountry())
                .counterpartyId(request.getCounterpartyId())
                .currency(request.getCurrency())
                .cobDate(changeDateFormat(request))
                .amount(request.getAmount())
                .tradeTax(request.getTradeTax())
                .book(request.getBook())
                .counterparty(request.getCounterparty())

                .build();
    }

    public String changeDateFormat(Trade request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return dateFormat.format(request.getCobDate());
    }

    public Header getHeader(Trade request){

        Header header = new Header();

            header.setId(request.getId());
            header.setTradeName(request.getTradeName());
            return header;
      
    }
}
