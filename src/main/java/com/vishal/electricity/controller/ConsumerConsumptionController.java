package com.vishal.electricity.controller;

import com.vishal.electricity.constants.ConsumerType;
import com.vishal.electricity.dto.BillingDetails;
import com.vishal.electricity.entity.Consumer;
import com.vishal.electricity.entity.ConsumerConsumption;
import com.vishal.electricity.repository.ConsumerConsumptionRepository;
import com.vishal.electricity.service.ConsumerConsumptionService;
import com.vishal.electricity.service.ConsumerService;
import com.vishal.electricity.util.ConsumerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/billing")
public class ConsumerConsumptionController {

    @Autowired
    ConsumerConsumptionService consumerConsumptionService;

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer/{id}/days/{days}")
    public ResponseEntity<?> getConsumerBill(@PathVariable Integer id, @PathVariable Integer days) {
        Consumer consumer = consumerService.findConsumerById(id).get();
        Integer totalUnits = consumerConsumptionService.fetchTotalUnits(id, days);
        int billAmount = ConsumerUtils.getBillAmount(consumer, totalUnits);
        BillingDetails billingDetails = ConsumerUtils.generateBillDetails(consumer, billAmount);
        return ResponseEntity.ok(billingDetails);
    }

    @PostMapping
    public ConsumerConsumption createConsumerConsumption(@RequestBody ConsumerConsumption consumerConsumption){
        return consumerConsumptionService.saveConsumerConsumption(consumerConsumption);
    }


}
