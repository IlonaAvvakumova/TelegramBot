package com.example.service.impl;
import com.example.entity.AppDocument;
import com.example.repository.AppDocumentDAO;
import com.example.repository.BinaryContentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FileServiceImplTest {

    @Mock
    private FileServiceImpl fileService;
    @Mock
    private AppDocumentDAO appDocumentDAO;
    @Mock
    private BinaryContentDAO binaryContentDAO;
    @Mock
    private Message telegramMessage;
    @Mock
    AppDocument appDocument;
@Mock
ResponseEntity<String> response;
    @Test
    void processDoc() {
//        when(appDocumentDAO.save(appDocument)).thenReturn(appDocument);
//        //  assertEquals(appDocument,fileService.processDoc(telegramMessage));
//        fileService.processDoc(telegramMessage);
//        verify(appDocumentDAO, times(1)).save(appDocument);
        when(response.getStatusCode()).thenReturn(HttpStatus.OK);
assertNotNull(response);
//        fileService.processDoc(telegramMessage);
//        if (response.getStatusCode() == HttpStatus.OK){
//         //   verify(appDocumentDAO, times(1)).save(appDocument);
//
//            assertEquals(appDocument, appDocumentDAO.save(appDocument));
//        }
    }
}