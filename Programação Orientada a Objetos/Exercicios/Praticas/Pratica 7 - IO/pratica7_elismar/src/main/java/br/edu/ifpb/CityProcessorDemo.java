package br.edu.ifpb;

import br.edu.ifpb.models.City;
import br.edu.ifpb.repository.CityParser;
import br.edu.ifpb.services.CityProcessor;
import br.edu.ifpb.services.ComparatorByState;
import br.edu.ifpb.services.ComparatorByZipCode;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;

public class CityProcessorDemo {
    public static void main(String[] args) {
        CityProcessor cityProcessor = new CityProcessor(new CityParser("./data/cities_duplicatas.txt"));
        Set<City> citySet = cityProcessor.getAllCities();
        cityProcessor.setCities(citySet);

        cityProcessor.saveAllCities(Path.of("data/cities_ordered_by_name.txt"), Comparator.naturalOrder() );

        ComparatorByZipCode comparatorZip = new ComparatorByZipCode();
        cityProcessor.saveAllCities(Path.of("data/cities_ordered_by_zipcode.txt"), comparatorZip );

        ComparatorByState comparatorState = new ComparatorByState();
        cityProcessor.saveAllCities(Path.of("data/cities_ordered_by_state.txt"), comparatorState );
    }
}
