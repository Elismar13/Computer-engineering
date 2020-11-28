package br.edu.ifpb.repository;

import br.edu.ifpb.models.City;

import java.util.Set;

public interface CityDatabaseMiddleware {
    Set<City> buildSetOfCities();
    boolean writeSetOfCities(Set<City> cities);
}
