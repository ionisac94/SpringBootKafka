#Spring Boot with Kafka Example

This Project covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic.

#Start Zookeeper

bin/zookeeper-server-start.sh config/zookeeper.properties

#Start Kafka Server

bin/kafka-server-start.sh config/server.properties

#Create Kafka Topic

bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic KAFKA_TOPIC1

#Publish message via WebService

http://localhost:8083/test/message