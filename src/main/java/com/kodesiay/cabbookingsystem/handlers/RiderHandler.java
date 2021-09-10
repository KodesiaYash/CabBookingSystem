package com.kodesiay.cabbookingsystem.handlers;

import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Ride;

import java.util.List;

public interface RiderHandler {
    void takeInput();
    void register();
    String bookCab();
    void rideCab();
    List<Ride> fetchRideHistory();
    void endTrip();
}
