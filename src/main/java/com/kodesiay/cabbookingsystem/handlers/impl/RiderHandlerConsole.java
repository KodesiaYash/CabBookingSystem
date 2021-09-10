package com.kodesiay.cabbookingsystem.handlers.impl;

import com.kodesiay.cabbookingsystem.exception.InvalidDetailsException;
import com.kodesiay.cabbookingsystem.exception.RiderFunctionalityNotFound;
import com.kodesiay.cabbookingsystem.handlers.RiderHandler;
import com.kodesiay.cabbookingsystem.manager.RiderManager;
import com.kodesiay.cabbookingsystem.manager.RideManager;
import com.kodesiay.cabbookingsystem.model.Ride;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RiderHandlerConsole implements RiderHandler {
    private RiderManager riderManager;
    private RideManager rideManager;
    private Scanner takeInput = new Scanner(System.in);
    private HashMap<String,Runnable> functionToExecute = new HashMap<String,Runnable>(){
        {
            put("REGISTER",RiderHandlerConsole.this::register);
            put("BOOK_CAB",RiderHandlerConsole.this::bookCab);
            put("FETCH_RIDE_HISTORY",RiderHandlerConsole.this::fetchRideHistory);
            put("END_TRIP",RiderHandlerConsole.this::endTrip);
        }
    };

    @NonNull
    public RiderHandlerConsole(RiderManager riderManager, RideManager rideManager) {
        this.riderManager = riderManager;
        this.rideManager = rideManager;
    }

    @Override
    public void takeInput() {
        String riderFunction = takeInput.nextLine();
        if(!functionToExecute.containsKey(riderFunction)) {
            throw new RiderFunctionalityNotFound();
        }
        functionToExecute.get(riderFunction).run();
    }

    @Override
    public void register() {
        String riderId = takeInput.nextLine();
        String riderName = takeInput.nextLine();;
        String riderEmailName = takeInput.nextLine();
        if(riderName.isEmpty() || riderEmailName.isEmpty()) {
            throw new InvalidDetailsException();
        }
        riderManager.register(riderName, riderEmailName);
    }

    @Override
    public String bookCab() {
        String riderEmailId = takeInput.nextLine();
        int sourceX = Integer.valueOf(takeInput.next()), sourceY = Integer.valueOf(takeInput.next());
        int destX = Integer.valueOf(takeInput.next()), destY = Integer.valueOf(takeInput.next());
        String bookedCabRideId= rideManager.bookCab(riderEmailId,sourceX,sourceY,destX,destY);
        return bookedCabRideId;
    }

    @Override
    public void rideCab() {
        String rideId = takeInput.nextLine();
        rideManager.rideCab(rideId);
    }

    @Override
    public List<Ride> fetchRideHistory() {
        String riderId = takeInput.nextLine();
        return rideManager.getRidesForRider(riderId);
    }

    @Override
    public void endTrip() {
        String rideId = takeInput.nextLine();
        rideManager.endRide(rideId);
    }
}
