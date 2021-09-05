package com.kodesiay.cabbookingsystem.handlers.impl;

import com.kodesiay.cabbookingsystem.exception.CabFunctionalityNotFound;
import com.kodesiay.cabbookingsystem.exception.RiderFunctionalityNotFound;
import com.kodesiay.cabbookingsystem.handlers.CabHandler;
import com.kodesiay.cabbookingsystem.manager.CabManager;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;

import java.io.IOException;
import java.util.*;

public class CabHandlerConsole implements CabHandler {

    private CabManager cabManager;
    public CabHandlerConsole(CabManager cabManager) {
        this.cabManager = cabManager;
    }
    private Scanner takeInput = new Scanner(System.in);
    private HashMap<String,Runnable> functionToExecute = new HashMap<String,Runnable>(){
        {
            put("REGISTER",CabHandlerConsole.this::register);
            put("UPDATE_LOCATION",CabHandlerConsole.this::updateLocation);
            put("UPDATE_CAB_AVAILABILITY",CabHandlerConsole.this::updateCabAvailability);
            put("GET_CABS",CabHandlerConsole.this::getCabs);
        }
    };

    @Override
    public void getCabFunctionalityInput() throws CabFunctionalityNotFound {
        String cabFunction = takeInput.nextLine();
        functionToExecute.get(cabFunction).run();
    }

    @Override
    public void register() {
        String cabId = takeInput.nextLine();
        String driverName = takeInput.nextLine();
        cabManager.register(cabId,driverName);
    }

    @Override
    public void updateLocation() {
        String cabId = takeInput.nextLine();
        int X = Integer.valueOf(takeInput.next()), Y = Integer.valueOf(takeInput.next());
        cabManager.updateLocation(cabId, new Location(X,Y));
    }

    @Override
    public void updateCabAvailability() {
        String cabId = takeInput.nextLine();
        int availability = Integer.valueOf(takeInput.next());
        HashSet<Integer> availabilityStates = new HashSet<Integer>(Arrays.asList(0,1));
        if(availabilityStates.contains(availability))
            cabManager.updateCabAvailability(cabId,availability);
        else
            throw new RuntimeException("Not a valid availability state");
    }

    @Override
    public List<Cab> getCabs() {
        int X = Integer.valueOf(takeInput.next()), Y = Integer.valueOf(takeInput.next());
        return cabManager.getCabs(new Location(X,Y));
    }
}
