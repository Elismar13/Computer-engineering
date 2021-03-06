package br.edu.ifpb.repository;

import br.edu.ifpb.models.City;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;

public interface CityDatabaseMiddleware {
    Set<City> buildSetOfCities();
    boolean writeSetOfCities(Path destination, Comparator<City> comparator, Set<City> cities);
}
