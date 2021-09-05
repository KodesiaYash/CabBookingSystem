package com.kodesiay.cabbookingsystem.model.impl;

import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.model.Ride;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class NormalCab implements Cab {
    private String id;
    private String driverName;

    @NonNull
    public NormalCab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
    }

    @Setter
    Ride currentTrip;
    @Setter
    Location currentLocation;
    @Setter int availability;
}
