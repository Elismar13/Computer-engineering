package br.edu.ifpb;

import br.edu.ifpb.repository.CityTextParser;
import br.edu.ifpb.services.CityProcessor;

public class CityProcessorDemo {
    public static void main(String[] args) {
        CityProcessor cityProcessor = new CityProcessor(new CityTextParser("./data/cities.txt"));
        cityProcessor.getAllCities();
    }
}
