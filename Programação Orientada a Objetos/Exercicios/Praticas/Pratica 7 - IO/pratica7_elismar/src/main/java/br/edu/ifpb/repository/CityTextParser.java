package br.edu.ifpb.repository;

import br.edu.ifpb.models.City;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class CityTextParser implements CityDatabaseMiddleware {
    private String filePath;

    public CityTextParser(String filePath) {
        this.setFilePath(filePath);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<City> buildSetOfCities() {
        TreeSet<City> cities = new TreeSet<>();
        char[] lineBuffer = new char[8*1024];

        try(
            Reader file = new FileReader(filePath);
            BufferedReader buffer = new BufferedReader( file );
        ) {
            String line = buffer.readLine();
            while(line != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String uf = data[1].trim();
                Integer id = new Integer(data[2].trim());

                City newCity = new City(name, uf, id);
                cities.add(newCity);

                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Problem while reading file. Please, check file corruption or user privileges.");
        }

        return null;
    }

    @Override
    public boolean writeSetOfCities(Set<City> cities) {
        return false;
    }
}
