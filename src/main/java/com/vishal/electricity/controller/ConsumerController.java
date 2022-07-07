package com.vishal.electricity.controller;


import com.vishal.electricity.entity.Consumer;
import com.vishal.electricity.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping
    public Consumer createConsumer( @RequestBody Consumer consumer) {
        return consumerService.saveConsumer(consumer);
    }

    @GetMapping
    public List<Consumer> getAllConsumers() {
        return consumerService.findConsumers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Consumer>> getConsumerById(@PathVariable(value = "id") Integer consumerId) {
        Optional<Consumer> consumer = consumerService.findConsumerById(consumerId);
        return ResponseEntity.ok().body(consumer);
    }

    @PutMapping("/{id}")
    public  Consumer  updateConsumer(@PathVariable(value = "id") Integer consumerId,
                                                      @RequestBody Consumer consumerDetails)  {
        Optional<Consumer> optionalConsumer = consumerService.findConsumerById(consumerId);

        if (!optionalConsumer.isPresent()){ return null; }
        Consumer consumer = optionalConsumer.get();
        consumer.setEmail(consumerDetails.getEmail());
        consumer.setName(consumerDetails.getName());
        consumer.setCategory(consumerDetails.getCategory());
        final Consumer updatedConsumer = consumerService.saveConsumer(consumer);
        return  updatedConsumer;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsumer(@PathVariable(value = "id") Integer consumerId) {

        consumerService.deleteConsumer(consumerId);
        return ResponseEntity.ok().body("User deleted");
    }



}
