package com.vishal.electricity.repository;

import com.vishal.electricity.entity.ConsumerConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerConsumptionRepository extends JpaRepository<ConsumerConsumption, Long> {

    @Query(value = "SELECT sum(cc.units) from consumer_consumption cc where cc.consumer_id = ?1 LIMIT ?2", nativeQuery = true)
    Integer findUnitsByConsumerIdAndDays(Integer id, Integer days);
}
