package com.kodesiay.cabbookingsystem.strategies.impl;

import com.kodesiay.cabbookingsystem.dao.CabDao;
import com.kodesiay.cabbookingsystem.exception.NoCabAvailable;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.strategies.CabDiscoveryStrategy;
import com.kodesiay.cabbookingsystem.strategies.CabMatchingStrategy;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    private CabDao cabDao;
    private CabDiscoveryStrategy cabDiscoveryStrategy;
    private Location source;
    private Location dest;

    @Override
    public Cab matchCab() {
        List<Cab> cabs = cabDiscoveryStrategy.find(source,cabDao);
        if(cabs.isEmpty())
            throw new NoCabAvailable();
        return cabs.get(0);
    }
}
