DROP TABLE IF EXISTS logmessage;

CREATE TABLE log_message
(
    id int GENERATED BY DEFAULT AS IDENTITY,
    message TEXT
);

TRUNCATE TABLE log_message RESTART IDENTITY;