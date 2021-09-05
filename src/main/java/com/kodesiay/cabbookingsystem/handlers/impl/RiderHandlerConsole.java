package com.kodesiay.cabbookingsystem.handlers.impl;

import com.kodesiay.cabbookingsystem.exception.InvalidDetailsException;
import com.kodesiay.cabbookingsystem.exception.RiderFunctionalityNotFound;
import com.kodesiay.cabbookingsystem.handlers.RiderHandler;
import com.kodesiay.cabbookingsystem.manager.RiderManager;
import com.kodesiay.cabbookingsystem.manager.TripManager;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Ride;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Scanner;

public class RiderHandlerConsole implements RiderHandler {
    private RiderManager riderManager;
    private TripManager tripManager;
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
    public RiderHandlerConsole(RiderManager rideManager) {
        this.riderManager = rideManager;
        this.tripManager = tripManager;
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
        String riderId = takeInput.nextLine();;
        String riderName = takeInput.nextLine();;
        String riderEmailName = takeInput.nextLine();
        if(riderName.isEmpty() || riderEmailName.isEmpty()) {
            throw new InvalidDetailsException();
        }
        riderManager.register(riderName, riderEmailName);
    }

    @Override
    public void bookCab() {

    }

    @Override
    public Ride fetchRideHistory() {
        return null;
    }

    @Override
    public void endTrip() {

    }
}
