package com.vishal.electricity.service;

import com.vishal.electricity.entity.Consumer;
import com.vishal.electricity.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;


    @Override
    public Consumer saveConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);

    }

    @Override
    public List<Consumer> findConsumers() {
        return consumerRepository.findAll();
    }

    @Override
    public Optional<Consumer> findConsumerById(Integer id) {
        Optional<Consumer> consumer = consumerRepository.findById(id);
        return consumer;
    }

    @Override
    public void deleteConsumer(Integer id) {
        consumerRepository.deleteById(id);
    }


}
