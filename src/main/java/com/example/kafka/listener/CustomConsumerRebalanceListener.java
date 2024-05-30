package com.example.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
@Slf4j
public class CustomConsumerRebalanceListener implements ConsumerRebalanceListener, ConsumerSeekAware {

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        // TODO Выполнить действия при отзыве партиций у потребителя
        log.info("Partitions revoked: {}", partitions);
    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        // TODO Выполнить действия при назначении партиций потребителю
        log.info("Partitions assigned: {}", partitions);
    }

    @Override
    public void registerSeekCallback(ConsumerSeekCallback callback) {
        // TODO Здесь можно зарегистрировать обратный вызов, который будет вызываться, когда потребитель будет перезапускаться и сбрасывать положение чтения до начала партиции
    }

    @Override
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        // TODO Здесь можно выполнять дополнительные действия при назначении партиций потребителю, такие как сброс положения чтения или другие манипуляции с данными
    }

    @Override
    public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        // TODO Вызывается, когда контейнер KafkaListener находится в режиме простоя
    }
}

