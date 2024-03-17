package ru.aston.crm.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LogMessageService {

    @Autowired
    private LogMessageRepository logMessageRepository;

    @KafkaListener(topics = "cms", groupId = "loggingServiceGroup")
    public void listen(@RequestBody LogMessage message) {
        LogMessage logMessage = new LogMessage();
        logMessage.setMessage(message.getMessage());
        logMessageRepository.save(logMessage);
    }
}
