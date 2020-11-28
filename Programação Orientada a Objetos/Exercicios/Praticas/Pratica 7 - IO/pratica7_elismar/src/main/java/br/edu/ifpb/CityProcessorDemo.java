package br.edu.ifpb;

import br.edu.ifpb.models.City;
import br.edu.ifpb.repository.CityParser;
import br.edu.ifpb.services.CityProcessor;

import java.nio.file.Path;
import java.util.Set;

public class CityProcessorDemo {
    public static void main(String[] args) {
        CityProcessor cityProcessor = new CityProcessor(new CityParser("./data/cities_duplicatas.txt"));
        Set<City> citySet = cityProcessor.getAllCities();

        cityProcessor.saveAllCities(Path.of("data/cities_backup.txt"), citySet);
    }
}
