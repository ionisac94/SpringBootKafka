# Spring Boot with Kafka Example

This Project covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic.

# Start Zookeeper

bin/zookeeper-server-start.sh config/zookeeper.properties
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

# Start Kafka Server

bin/kafka-server-start.sh config/server.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties

# Create Kafka Topic

bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic KAFKA_TOPIC1
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic KAFKA_TOPIC2

# Delete Kafka Topic
//https://stackoverflow.com/questions/33537950/how-to-delete-a-topic-in-apache-kafka

bin/kafka-topics.sh --delete  --zookeeper localhost:2181  --topic KAFKA_TOPIC1

# List Kafka Topics

bin/kafka-topics.sh --list --zookeeper localhost:2181
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092  localhost:2181 -list

# Publish message via WebService

http://localhost:8083/test/message

# Useful info

How can I remove the current process/application which is already assigned to a specific port usin CMD?
1. find who is listening on a specific port
    netstat -ano | findstr :PORT_NAME
2. next, run the following command to kill the process
    taskkill /PID PID_NAME /F
 
# https://www.youtube.com/watch?v=aKDWWICgfA0 & https://www.youtube.com/watch?v=NjHYWEV_E_o