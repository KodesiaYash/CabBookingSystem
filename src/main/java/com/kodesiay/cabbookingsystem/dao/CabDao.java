package com.kodesiay.cabbookingsystem.dao;

import com.kodesiay.cabbookingsystem.exception.CabIdAlreadyExists;
import com.kodesiay.cabbookingsystem.exception.CabIdDoesNotExist;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.model.impl.NormalCab;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class CabDao {
    HashMap<String, Cab> cabDatabase ;

    public void add(String cabId, String driverName) {
        Cab newCab = new NormalCab(cabId,driverName);
        if(cabDatabase.containsKey(cabId)) {
            throw new CabIdAlreadyExists();
        }
        cabDatabase.put(cabId,newCab);
    }

    public void update(String cabID, Location currentLocation) {
        if(!cabDatabase.containsKey(cabID))
            throw new CabIdDoesNotExist();
        NormalCab cab = (NormalCab) cabDatabase.get(cabID);
        cab.setCurrentLocation(currentLocation);
        cabDatabase.put(cabID,cab);
    }

    public void update(String cabID, int availability) {
        if(!cabDatabase.containsKey(cabID))
            throw new CabIdDoesNotExist();
        NormalCab cab = (NormalCab) cabDatabase.get(cabID);
        cab.setAvailability(availability);
        cabDatabase.put(cabID,cab);
    }

    public List<Cab> getAll() {
        List<Cab> allCabs = new ArrayList<>(cabDatabase.values());
        return allCabs;
    }
}
