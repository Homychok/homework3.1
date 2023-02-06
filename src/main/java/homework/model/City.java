package homework.model;

import java.util.Objects;

public class City {
    private String city_name;
    private Integer city_id;

    public City(String city_name, Integer city_id) {
        this.city_name = city_name;
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getCity_name().equals(city.getCity_name()) && getCity_id().equals(city.getCity_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity_name(), getCity_id());
    }

    @Override
    public String toString() {
        return "City{" +
                "city_name='" + city_name + '\'' +
                ", city_id=" + city_id +
                '}';
    }
}
