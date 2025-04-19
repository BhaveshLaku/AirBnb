package com.bhavesh.airbnbapp.strategy;

import com.bhavesh.airbnbapp.entity.Inventory;

import java.math.BigDecimal;


public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
