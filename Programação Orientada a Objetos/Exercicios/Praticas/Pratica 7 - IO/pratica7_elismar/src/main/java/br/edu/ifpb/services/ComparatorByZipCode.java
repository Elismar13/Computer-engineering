package br.edu.ifpb.services;

import br.edu.ifpb.models.City;

import java.util.Comparator;

public class ComparatorByZipCode implements Comparator<City> {
    @Override
    public int compare(City city, City c1) {
        return Integer.compare(city.getCityId(), c1.getCityId());
    }
}
