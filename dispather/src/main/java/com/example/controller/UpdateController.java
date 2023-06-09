package com.example.controller;


import com.example.service.UpdateProducer;
import com.example.utils.MessageUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import static com.example.model.RabbitQueue.*;
@Component
@Slf4j

public class UpdateController {

    private TelegramBot telegramBot;
    private  MessageUtils messageUtils;
    private  UpdateProducer updateProducer;

    public UpdateController(MessageUtils messageUtils, UpdateProducer updateProducer) {
        this.messageUtils = messageUtils;
        this.updateProducer = updateProducer;
    }

    //DI не используется, из-за круговой зависимости классов
    public void registerBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    //валидация входящих данных
    public void processUpdate(Update update) {
        if (update == null) {
            log.error("Received update is null");
            return;
        }
        if (update.getMessage() != null) {
            distributeMessagesByType(update);
        } else {
            log.error("Unsupported  message type is received: " + update);
        }
    }

    //распределение по очередям по типу входящих данных
    private void distributeMessagesByType(Update update) {
        var message = update.getMessage();
        if (message.getText() != null) {
            processTextMessage(update);
        } else if (message.getDocument() != null) {
            processDocMessage(update);
        } else if (message.getPhoto() != null) {
            processPhotoMessage(update);
        } else {
            setUnsupportedMessageTypeView(update);
        }
    }

    private void setUnsupportedMessageTypeView(Update update) {
        var sendMessage = messageUtils.generateSendMessageWithText(update,
                "Не поддерживаемый тип сообщения!");
        setView(sendMessage);
    }

   public void setView(SendMessage sendMessage) {
        telegramBot.sendAnswerMessage(sendMessage);
    }

    private void processPhotoMessage(Update update) {
        updateProducer.produce(PHOTO_MESSAGE_UPDATE, update);
        setFileIsReceivedView(update);
    }

    private void processDocMessage(Update update) {
        updateProducer.produce(DOC_MESSAGE_UPDATE, update);
        setFileIsReceivedView(update);
    }

    private void processTextMessage(Update update) {
        updateProducer.produce(TEXT_MESSAGE_UPDATE, update);
        setFileIsReceivedView(update);
    }
    private void setFileIsReceivedView(Update update) {
        var sendMessage = messageUtils.generateSendMessageWithText(update,
                "Файл получен, идет обработка...");
        setView(sendMessage);
    }
}
