package com.kodesiay.cabbookingsystem.strategies.impl;

import com.kodesiay.cabbookingsystem.dao.CabDao;
import com.kodesiay.cabbookingsystem.model.Cab;
import com.kodesiay.cabbookingsystem.model.Location;
import com.kodesiay.cabbookingsystem.model.impl.NormalCab;
import com.kodesiay.cabbookingsystem.strategies.CabDiscoveryStrategy;
import lombok.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class DefaultCabDiscoveryStrategy implements CabDiscoveryStrategy {

    public static double CUTOFF_DIST = 100.00;
    @Override
    @NonNull
    public List<Cab> find(Location riderLocation, CabDao cabDao) {
        List<Cab> allCabs = cabDao.getAll().stream().map(cab -> (NormalCab)cab).collect(Collectors.toList());
        List<Cab> cabsWithinRange = new List<Cab>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Cab> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Cab cab) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Cab> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Cab> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Cab get(int index) {
                return null;
            }

            @Override
            public Cab set(int index, Cab element) {
                return null;
            }

            @Override
            public void add(int index, Cab element) {

            }

            @Override
            public Cab remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Cab> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Cab> listIterator(int index) {
                return null;
            }

            @Override
            public List<Cab> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for(Cab cab : allCabs) {
            if(cab.getAvailability()==1 && isCabWithinCutoffRange(riderLocation,cab.getCurrentLocation())) {
                cabsWithinRange.add(cab);
            }
        }
        return cabsWithinRange;
    }

    private static boolean isCabWithinCutoffRange(Location rider, Location cab) {
        return (Math.sqrt(Math.pow(rider.getX()-cab.getX(),2) + Math.pow(rider.getY()-cab.getY(),2)) <= CUTOFF_DIST);
    }
}
