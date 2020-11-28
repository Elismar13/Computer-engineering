package br.edu.ifpb.services;

import br.edu.ifpb.models.City;
import br.edu.ifpb.repository.CityDatabaseMiddleware;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CityProcessor {
    CityDatabaseMiddleware databaseMiddleware;

    public CityProcessor(CityDatabaseMiddleware databaseMiddleware) {
        this.databaseMiddleware = databaseMiddleware;
    }

    public TreeSet<City> getAllCities() {
        TreeSet<City> cities = (TreeSet) databaseMiddleware.buildSetOfCities();;

        return cities;
    }

    public boolean saveAllCities(Path fileDestinationPath, Set<City> cities) {
        return databaseMiddleware.writeSetOfCities(fileDestinationPath, cities);
    }
}
