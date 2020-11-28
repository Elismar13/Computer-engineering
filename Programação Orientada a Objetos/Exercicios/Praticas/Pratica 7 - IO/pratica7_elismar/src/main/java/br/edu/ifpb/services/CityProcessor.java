package br.edu.ifpb.services;

import br.edu.ifpb.models.City;
import br.edu.ifpb.repository.CityDatabaseMiddleware;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CityProcessor {
    CityDatabaseMiddleware databaseMiddleware;
    Set<City> cities;

    public CityProcessor(CityDatabaseMiddleware databaseMiddleware) {
        this.databaseMiddleware = databaseMiddleware;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public TreeSet<City> getAllCities() {
        TreeSet<City> cities = (TreeSet) databaseMiddleware.buildSetOfCities();;

        return cities;
    }

    public boolean saveAllCities(Path fileDestinationPath, Comparator<City> comparator) {
        return databaseMiddleware.writeSetOfCities(fileDestinationPath, comparator, getCities());
    }
}
