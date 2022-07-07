package com.vishal.electricity.service;

import com.vishal.electricity.entity.Consumer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ConsumerService {
    Consumer saveConsumer(Consumer consumer);
    List<Consumer> findConsumers();

    Optional<Consumer> findConsumerById(Integer id);

    void deleteConsumer(Integer id);

}
