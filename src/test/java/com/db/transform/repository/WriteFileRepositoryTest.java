package com.db.transform.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WriteFileRepositoryTest {

    WriteFileRepository writeFileRepository;

    @BeforeEach
    void setup(){
        writeFileRepository = new WriteFileRepository();
    }

    @Test
    public void catchIOExceptionWhenWritingAFile() {
        writeFileRepository.formatXML("",null);
        assertThrows(Exception.class, () -> writeFileRepository.formatXML(null,null));

    }

}

