package cityapp;

import java.math.BigDecimal;

public class City {
    private final int id;
    private final String name;
    private final BigDecimal longitude;
    private final BigDecimal latitude;
    private final String countryCode;
    private final int population;

    public City(int id, String name, BigDecimal longitude, BigDecimal latitude, String countryCode, int population) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.countryCode = countryCode;
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", countryCode='" + countryCode + '\'' +
                ", population=" + population +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getPopulation() {
        return population;
    }
}
