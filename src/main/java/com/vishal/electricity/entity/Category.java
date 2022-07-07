package com.vishal.electricity.entity;

import com.vishal.electricity.constants.ConsumerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Enumerated(EnumType.STRING)
    private ConsumerType type;
    private int costPerUnit;
    private int exemptedUnits;


}
