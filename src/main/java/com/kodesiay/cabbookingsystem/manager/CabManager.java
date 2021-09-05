package com.kodesiay.cabbookingsystem.manager;

import com.kodesiay.cabbookingsystem.dao.CabDao;
import com.kodesiay.cabbookingsystem.exception.CabIdAlreadyExists;
import com.kodesiay.cabbookingsystem.exception.CabIdDoesNotExist;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.strategies.CabDiscoveryStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class CabManager {
    private CabDao cabDao;
    private CabDiscoveryStrategy cabDiscoverStrategy;

    @NonNull
    public void register(String cabId, String driverName) throws CabIdAlreadyExists {
        cabDao.add(cabId,driverName);
    }

    @NonNull
    public void updateLocation(String cabId, Location currentLocation) throws CabIdDoesNotExist {
        cabDao.update(cabId,currentLocation);
    }

    @NonNull
    public void updateCabAvailability(String cabId, int availability) throws CabIdDoesNotExist {
        cabDao.update(cabId,availability);
    }

    public List<Cab> getCabs(Location currentLocation) {
        return cabDiscoverStrategy.find(currentLocation,cabDao);
    }
}
