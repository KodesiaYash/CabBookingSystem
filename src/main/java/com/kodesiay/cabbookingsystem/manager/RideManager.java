package com.kodesiay.cabbookingsystem.manager;

import com.kodesiay.cabbookingsystem.dao.CabDao;
import com.kodesiay.cabbookingsystem.dao.RideDao;
import com.kodesiay.cabbookingsystem.dao.RiderDao;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.model.Ride;
import com.kodesiay.cabbookingsystem.model.Rider;
import com.kodesiay.cabbookingsystem.model.impl.NonSharingRide;
import com.kodesiay.cabbookingsystem.model.impl.NormalCab;
import com.kodesiay.cabbookingsystem.model.impl.RideStatus;
import com.kodesiay.cabbookingsystem.strategies.CabDiscoveryStrategy;
import com.kodesiay.cabbookingsystem.strategies.CabMatchingStrategy;
import com.kodesiay.cabbookingsystem.strategies.PriceMatchingStrategy;
import com.kodesiay.cabbookingsystem.strategies.impl.DefaultCabMatchingStrategy;
import com.kodesiay.cabbookingsystem.strategies.impl.DefaultPriceMatchingStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
public class RideManager {
    private CabDao cabDao;
    private CabDiscoveryStrategy cabDiscoverStrategy;
    private RiderDao riderDao;
    private RideDao rideDao;

    @NonNull
    public String bookCab(String riderEmailId, int sourceX, int sourceY, int destX, int destY) {
        Rider rider= riderDao.get(riderEmailId);
        Location source = new Location(sourceX,sourceY);
        Location dest = new Location(destX,destY);
        CabMatchingStrategy cabMatchingStrategy = new DefaultCabMatchingStrategy(cabDao,cabDiscoverStrategy,source,dest);
        Cab cab = (NormalCab)cabMatchingStrategy.matchCab();
        PriceMatchingStrategy priceMatchingStrategy = new DefaultPriceMatchingStrategy(cabMatchingStrategy,source,dest);
        Double price = priceMatchingStrategy.calculatePrice();
        String rideId = UUID.randomUUID().toString();
        Ride ride = new NonSharingRide(rideId,rider,cab,price, RideStatus.SCHEDULED,source,dest);
        rideDao.add(ride);
        return rideId;
    }

    @NonNull
    public void rideCab(String rideId) {
        rideDao.setRideStatus(rideId,RideStatus.IN_PROGRESS);
    }

    @NonNull
    public void endRide(String rideId) {
        rideDao.setRideStatus(rideId,RideStatus.FINISHED);
    }

    @NonNull
    public List<Ride> getRidesForRider(String riderId) {
        return rideDao.getRidesForRider(riderId);
    }
}
