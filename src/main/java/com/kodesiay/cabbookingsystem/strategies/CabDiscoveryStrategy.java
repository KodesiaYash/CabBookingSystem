package com.kodesiay.cabbookingsystem.strategies;

import com.kodesiay.cabbookingsystem.dao.CabDao;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;

import java.util.List;

public interface CabDiscoveryStrategy {
    List<Cab> find(Location location, CabDao cabDao);
}
