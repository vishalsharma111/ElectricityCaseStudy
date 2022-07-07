package com.vishal.electricity.service;

import com.vishal.electricity.entity.ConsumerConsumption;
import org.springframework.stereotype.Service;

@Service
public interface ConsumerConsumptionService {
    Integer fetchTotalUnits(Integer consumerId, Integer days);

    ConsumerConsumption saveConsumerConsumption(ConsumerConsumption consumerConsumption);
}
