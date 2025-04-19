package com.bhavesh.airbnbapp.strategy;

import com.bhavesh.airbnbapp.entity.Inventory;

import java.math.BigDecimal;


public class BasePricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
