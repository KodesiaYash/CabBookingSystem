package com.kodesiay.cabbookingsystem.model.impl;

import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.model.Ride;
import com.kodesiay.cabbookingsystem.model.Rider;
import lombok.AllArgsConstructor;
import lombok.ToString;

enum RideStatus{
    SCHEDULED,
    IN_PROGRESS,
    FINISHED
}

@ToString
@AllArgsConstructor
public class NonSharingRide implements Ride {
    private Rider rider;
    private Cab cab;
    private RideStatus rideStatus;
    private Location fromPoint;
    private Location toPoint;

    @Override
    public void endTrip() {
        this.rideStatus = RideStatus.FINISHED;
    }
}
