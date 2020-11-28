package br.edu.ifpb.repository;

import br.edu.ifpb.models.City;

/*
    Decidi criar essa classe para jogar a responsabilidade do geramento de cidades para essa classe,
    ao invés do CityParser. Caso surja algum novo campo das cidades no arquivo,
     apenas essa classe e a classe City terão que ser modificadas.

 */

public class CityUtils {
    public static City parseCityByLine(String cityLine) {
        String[] data = cityLine.split(",");
        String name = data[0].trim();
        String uf = data[1].trim();
        Integer id = new Integer(data[2].trim());

        City newCity = new City(name, uf, id);

        return newCity;
    }

    public static String generateCityLine(City city) {
        return String.format("%s, %s, %d%n", city.getName(), city.getFederationUnit(), city.getCityId());
    }
}
