package br.edu.ifpb.services;

import br.edu.ifpb.models.City;
import br.edu.ifpb.repository.CityDatabaseMiddleware;

import java.util.Comparator;
import java.util.TreeSet;

public class CityProcessor {
    CityDatabaseMiddleware databaseMiddleware;

    public CityProcessor(CityDatabaseMiddleware databaseMiddleware) {
        this.databaseMiddleware = databaseMiddleware;
    }

    public boolean saveAllCities(TreeSet<City> cities, Comparator<City> comparator) {
        return true;
    }

    public TreeSet<City> getAllCities() {
        TreeSet<City> cities = (TreeSet) databaseMiddleware.buildSetOfCities();;

        return cities;
    }
}
