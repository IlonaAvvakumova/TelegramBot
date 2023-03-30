package com.example.service.impl;
import com.example.entity.RowData;
import com.example.repository.RowJPA;
import com.example.service.MainService;
import com.example.service.ProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
@AllArgsConstructor
@Service
@Slf4j
public class MainServiceImpl implements MainService {

    private final RowJPA rowJPA;
    private final ProducerService producerService;


    @Override
    public void processTextMessage(Update update) {
        saveRowData(update);
        var message = update.getMessage();
        var sendMessage =new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from Node");
        producerService.producerAnswer(sendMessage);
    }

    private void saveRowData(Update update) {
        RowData row = RowData.builder().event(update).build();
        rowJPA.save(row);
    }
}
