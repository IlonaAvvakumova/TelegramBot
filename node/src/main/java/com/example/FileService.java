package com.example;
import com.example.entity.AppDocument;
import com.example.entity.AppPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;


public interface FileService {

    AppDocument processDoc(Message externalMessage);
    AppPhoto processPhoto(Message telegramMessage);
}
