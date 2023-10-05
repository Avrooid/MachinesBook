package ru.Burakov.MachinesBook.RabbitMQ;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitProducerImpl implements RabbitProducer{
    private final RabbitTemplate rabbitTemplate;

    @Override
    public String send(String message) {
        var temp = (byte[])rabbitTemplate.convertSendAndReceive("testExchange", "testRoutingKey",
                message);
        String response = new String(temp);
        log.info(response);
        return response;
    }
}
