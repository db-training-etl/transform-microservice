package com.db.transform.repositoryTest;

import com.db.transform.entity.Trade;
import com.db.transform.repository.WriteFileRepository;
import com.db.transform.service.TransformService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
public class WriteFileRepositoryTest {
    @Mock
    TransformService transformService;
    @Mock
    WriteFileRepository writeFileRepository;


}
