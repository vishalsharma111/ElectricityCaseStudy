package com.vishal.electricity.service;

import com.vishal.electricity.entity.ConsumerConsumption;
import com.vishal.electricity.repository.ConsumerConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerConsumptionServiceImpl implements ConsumerConsumptionService {

    @Autowired
    ConsumerConsumptionRepository consumerConsumptionRepository;

    @Override
    public Integer fetchTotalUnits(Integer consumerId, Integer days) {
        return consumerConsumptionRepository.findUnitsByConsumerIdAndDays(consumerId,days);
    }

    @Override
    public ConsumerConsumption saveConsumerConsumption(ConsumerConsumption consumerConsumption) {
        return  consumerConsumptionRepository.save(consumerConsumption);
    }
}
