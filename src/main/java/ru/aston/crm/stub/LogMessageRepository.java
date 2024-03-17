package ru.aston.crm.stub;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogMessageRepository extends JpaRepository<LogMessage, Integer> {
}
