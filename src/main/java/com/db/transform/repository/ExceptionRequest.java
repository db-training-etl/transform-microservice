package com.db.transform.repository;

import com.db.transform.entity.ExceptionModel;
import org.springframework.http.ResponseEntity;

public interface ExceptionRequest {

    ResponseEntity<ExceptionModel> postException(ExceptionModel exception);
}
