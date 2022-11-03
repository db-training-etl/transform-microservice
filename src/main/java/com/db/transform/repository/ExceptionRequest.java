package com.db.transform.repository;

import com.db.transform.entity.ExceptionModel;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface ExceptionRequest {

    ResponseEntity<ExceptionModel> postException(ExceptionModel exception);
}
