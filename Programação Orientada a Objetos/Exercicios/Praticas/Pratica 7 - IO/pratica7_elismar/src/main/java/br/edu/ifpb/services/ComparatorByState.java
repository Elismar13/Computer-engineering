package br.edu.ifpb.services;

import br.edu.ifpb.models.City;

import java.util.Comparator;

public class ComparatorByState implements Comparator<City> {
    @Override
    public int compare(City city, City c1) {
        return Character.compare(city.getName().charAt(0), c1.getName().charAt(0));
    }
}
