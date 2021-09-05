package com.kodesiay.cabbookingsystem.manager;

import com.kodesiay.cabbookingsystem.dao.CabDao;
import com.kodesiay.cabbookingsystem.dao.RiderDao;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.model.Ride;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class RiderManager {
    private RiderDao riderDao;
    private CabDao cabDao;

    @NonNull
    public void register(String riderName, String riderEmailId) {
        riderDao.add(riderName,riderEmailId);
    }

    @NonNull
    public void bookCab(Location currentLocation) {

    }

    @NonNull
    public List<Ride> fetchRideHistory(String riderId) {
        return null;
    }

    @NonNull
    public void endTrip(String riderId) {

    }
}
