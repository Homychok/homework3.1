package homework2.dao;

import homework2.model.City;

import java.util.List;

public interface CityDAO {
    void create (City city);
    City getCity(int id);
    List<City> getAllCities();
    void updateCity (City city);
    void deleteCity (City city);
}
