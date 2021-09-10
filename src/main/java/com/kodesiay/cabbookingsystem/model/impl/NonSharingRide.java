package com.kodesiay.cabbookingsystem.model.impl;

import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.model.Ride;
import com.kodesiay.cabbookingsystem.model.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class NonSharingRide implements Ride {
    private String rideId;
    private Rider rider;
    private Cab cab;
    private Double price;
    private RideStatus rideStatus;
    private Location fromPoint;
    private Location toPoint;

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
