package com.kodesiay.cabbookingsystem.dao;

import com.kodesiay.cabbookingsystem.exception.RiderNotFound;
import com.kodesiay.cabbookingsystem.exception.RiderWithEmailAlreadyExists;
import com.kodesiay.cabbookingsystem.model.Rider;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class RiderDao {
    HashMap<String, Rider> riderDatabase;

    public void add(String name, String emailId) {
        Rider rider = new Rider(name,emailId);
        if(riderDatabase.containsKey(emailId))
            throw new RiderWithEmailAlreadyExists();
        riderDatabase.put(emailId, rider);
    }

    public Rider get(String emailId) {
        if(!riderDatabase.containsKey(emailId))
            throw new RiderNotFound();
        return riderDatabase.get(emailId);
    }

}
