package com.kodesiay.cabbookingsystem.strategies.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Guitar {
    private String name;
    private String model;
    private double price;
    private double weight;


    public static void main(String args[]) {
        Guitar guitar = new Guitar("A","model",50.0,100);
        guitar.setPrice(60.0);
        System.out.println(guitar.getPrice());
    }
}

