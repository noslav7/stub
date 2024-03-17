package ru.aston.crm.stub;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogMessageService {

    @Autowired
    private LogMessageRepository logMessageRepository;

    @KafkaListener(topics = "cms", groupId = "loggingServiceGroup")
    public void listen(ConsumerRecord<String, String> record) {
        LogMessage logMessage = new LogMessage();
        logMessage.setLevel(record.key());
        logMessage.setMessage(record.value());
        logMessageRepository.save(logMessage);
    }
}
