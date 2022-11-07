package com.db.transform.exceptions;

import com.db.transform.entity.ExceptionModel;
import com.db.transform.service.ExceptionService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Date;

@ControllerAdvice
@AllArgsConstructor
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    ExceptionService exceptionService;

    @Override
    protected @NonNull ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {

        ExceptionModel exceptionModel = ExceptionModel.builder()
                .name("MethodArgumentNotValid")
                .type("MethodArgumentNotValid")
                .message(ex.getMessage())
                .trace(ExceptionUtils.getStackTrace(ex))
                .cobDate(Date.from(Instant.now()))
                .build();

        exceptionService.sendException(exceptionModel);
        return super.handleMethodArgumentNotValid(ex, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}