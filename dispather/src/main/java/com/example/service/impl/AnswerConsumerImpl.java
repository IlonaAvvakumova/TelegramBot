package com.example.service.impl;
import com.example.controller.UpdateController;
import com.example.service.AnswerConsumer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.example.model.RabbitQueue.ANSWER_MESSAGE;

@Service
@AllArgsConstructor
public class AnswerConsumerImpl implements AnswerConsumer {
private final UpdateController updateController;
    @Override
    @RabbitListener(queues = ANSWER_MESSAGE)
    public void consume(SendMessage sendMessage) {
        updateController.setView(sendMessage);
    }
}
