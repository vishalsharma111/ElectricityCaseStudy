package com.vishal.electricity.util;

import com.vishal.electricity.constants.ConsumerType;
import com.vishal.electricity.dto.BillingDetails;
import com.vishal.electricity.entity.Consumer;

import java.util.UUID;

public final class ConsumerUtils {

    public static int getBillAmount(Consumer consumer, Integer totalUnits) {
        if (ConsumerType.HOME_LOW == consumer.getCategory().getType()) {
            totalUnits -= consumer.getCategory().getExemptedUnits();
        }
        int billAmount = 0;
        if (totalUnits > 0) {
            billAmount = totalUnits * consumer.getCategory().getCostPerUnit();
        }
        return billAmount;
    }

    public static BillingDetails generateBillDetails(Consumer consumer, int billAmount) {
        BillingDetails billingDetails = new BillingDetails();
        billingDetails.setAmount(billAmount);
        billingDetails.setName(consumer.getName());
        billingDetails.setInvoiceNo(UUID.randomUUID().toString());
        return billingDetails;
    }
}
