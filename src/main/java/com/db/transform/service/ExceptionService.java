package com.db.transform.service;

import com.db.transform.entity.ExceptionModel;
import com.db.transform.repository.ExceptionRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExceptionService {

    ExceptionRequest exceptionRequest;

    public ResponseEntity<ExceptionModel> sendException(ExceptionModel exception){
        return exceptionRequest.postException(exception);
    }


}