package ru.aston.crm.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class LogMessageService {
    private final LogMessageRepository logMessageRepository;

    @Autowired
    public LogMessageService(LogMessageRepository logMessageRepository) {
        this.logMessageRepository = logMessageRepository;
    }

    @KafkaListener(topics = "cms", groupId = "cmsGroup")
    public void listen(LogMessage message) {
        LogMessage logMessage = new LogMessage();
        logMessage.setMessage(message.getMessage());
        logMessageRepository.save(logMessage);
    }
}
