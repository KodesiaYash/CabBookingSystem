package com.kodesiay.cabbookingsystem.handlers;

import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Ride;

public interface RiderHandler {
    void takeInput();
    void register();
    void bookCab();
    Ride fetchRideHistory();
    void endTrip();
}
