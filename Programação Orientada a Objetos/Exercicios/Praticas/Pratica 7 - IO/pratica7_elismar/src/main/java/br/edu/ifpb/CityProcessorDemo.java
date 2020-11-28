package br.edu.ifpb;

import br.edu.ifpb.repository.CityParser;
import br.edu.ifpb.services.CityProcessor;

public class CityProcessorDemo {
    public static void main(String[] args) {
        CityProcessor cityProcessor = new CityProcessor(new CityParser("./data/cities.txt"));
        cityProcessor.getAllCities();
    }
}
