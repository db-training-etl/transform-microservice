package com.db.transform.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransformControllerTest {
    @Mock
    TransformController controller;

    @Test
    void verifyIfMapTradeToXMLAndCreateFileIsCalled() {
        controller.mapTradeToXMLAndCreateFile(any());
        verify(controller,times(1)).mapTradeToXMLAndCreateFile(any());
    }

    @Test
    void verifyIfMapChunkOfTradeToXMLAndCreateFileIsCalled() {
        controller.mapChunkOfTradesToXMLAndCreateFile(any());
        verify(controller,times(1)).mapChunkOfTradesToXMLAndCreateFile(any());
    }

}
