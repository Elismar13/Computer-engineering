package br.edu.ifpb.models;

import java.util.Objects;

public class City implements Comparable<City> {
    private String name;
    private String federationUnit;
    private Integer CityId;

    public City(String name, String federationUnit, Integer cityId) {
        this.setName(name);
        this.setFederationUnit(federationUnit);
        this.setCityId(cityId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFederationUnit() {
        return federationUnit;
    }

    public void setFederationUnit(String federationUnit) {
        this.federationUnit = federationUnit;
    }

    public Integer getCityId() {
        return CityId;
    }

    public void setCityId(Integer cityId) {
        CityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city = (City) o;
        return Objects.equals(this.getName(), city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCityId());
    }

    @Override
    public int compareTo(City city) {
        return Integer.compare(getCityId(), city.getCityId());
    }
}
