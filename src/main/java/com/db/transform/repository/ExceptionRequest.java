package com.db.transform.repository;

import com.db.transform.entity.ExceptionModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

public interface ExceptionRequest {

    ResponseEntity<ExceptionModel> postException(ExceptionModel exception);
}
