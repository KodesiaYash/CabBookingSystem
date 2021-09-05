package com.kodesiay.cabbookingsystem.handlers;

import com.kodesiay.cabbookingsystem.model.Cab;

import java.io.IOException;
import java.util.List;

public interface CabHandler {
    void getCabFunctionalityInput();
    void register() throws IOException;
    void updateLocation() throws Exception;
    void updateCabAvailability() throws Exception;
    List<Cab> getCabs() throws Exception;
}
