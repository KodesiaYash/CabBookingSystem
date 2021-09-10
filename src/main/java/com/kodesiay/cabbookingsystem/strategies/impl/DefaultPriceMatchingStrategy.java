package com.kodesiay.cabbookingsystem.strategies.impl;

import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.strategies.CabMatchingStrategy;
import com.kodesiay.cabbookingsystem.strategies.PriceMatchingStrategy;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class DefaultPriceMatchingStrategy implements PriceMatchingStrategy {
    private CabMatchingStrategy cabMatchingStrategy;
    private Location source,dest;

    public static final int PER_KM_RATE = 10;
    @Override
    public Double calculatePrice() {
        return (Double)(Math.sqrt(Math.pow(source.getX()-dest.getX(),2) + Math.pow(source.getY()-dest.getY(),2)) * PER_KM_RATE);
    }
}
