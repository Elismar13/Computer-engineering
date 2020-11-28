package br.edu.ifpb.services;

import br.edu.ifpb.models.City;

import java.util.Comparator;

public class ComparatorByState implements Comparator<City> {
    @Override
    public int compare(City city, City c1) {
        return city.getName().compareTo(c1.getName());
    }
}
