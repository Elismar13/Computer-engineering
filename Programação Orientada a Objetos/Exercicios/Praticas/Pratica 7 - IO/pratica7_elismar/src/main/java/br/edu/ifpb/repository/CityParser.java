package br.edu.ifpb.repository;

import br.edu.ifpb.models.City;

import java.io.*;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CityParser implements CityDatabaseMiddleware {
    private String filePath;

    public CityParser(String filePath) {
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
                City newCity = CityUtils.parseCityByLine(line);
                cities.add(newCity);
                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Problem while reading file. Please, check file corruption or user privileges.");
        } catch (Exception e) {
            System.out.println("Erro ao gerar cidade. Causa: " + e.getMessage());
        }

        return cities;
    }

    @Override
    public boolean writeSetOfCities(Path destination, Comparator<City> comparator, Set<City> cities) {
        File newCityFile = new File(destination.toUri());

        // Criando uma nova árvore ordenada pelo critério escolhido
        Set<City> newSetToWrite = new TreeSet<City>(comparator);
        newSetToWrite.addAll(cities);

        try(
            FileWriter writer = new FileWriter(newCityFile);
            BufferedWriter buffer = new BufferedWriter(writer);
        ) {
            if(newCityFile.createNewFile()) return false;

            for(City city : newSetToWrite) {
                String line = CityUtils.generateCityLine(city);
                buffer.write(line, 0, line.length());
            }
            buffer.flush();
        } catch (IOException e) {
            System.out.println("Error while writing file.");
            return false;
        }

        return true;
    }
}
