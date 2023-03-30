package com.example.service.impl;
import static com.example.model.RabbitQueue.*;
import com.example.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@AllArgsConstructor
public class ProducerServiceImpl implements ProducerService {
private final RabbitTemplate rabbitTemplate;
    @Override
    public void producerAnswer(SendMessage sendMessage) {
        rabbitTemplate.convertAndSend(ANSWER_MESSAGE, sendMessage);
    }
}
