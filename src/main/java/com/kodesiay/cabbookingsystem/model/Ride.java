package com.kodesiay.cabbookingsystem.model;

import com.kodesiay.cabbookingsystem.model.impl.RideStatus;

public interface Ride {
    void setRideStatus(RideStatus rideStatus);
    String getRideId();
    Rider getRider();
    Cab getCab();
    Double getPrice();
    RideStatus getRideStatus();
    Location getToPoint();
    Location getFromPoint();

}
