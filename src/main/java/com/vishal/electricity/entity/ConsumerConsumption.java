package com.vishal.electricity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consumer_consumption")
public class ConsumerConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ccID;

    private Long date;
    private int units;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

}
