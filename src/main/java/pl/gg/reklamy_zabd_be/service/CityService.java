package pl.gg.reklamy_zabd_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.repository.JdbcCityRepository;

import java.util.List;

@Service
public class CityService {
    @Autowired
    JdbcCityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(int id) {
        return cityRepository.findById(id);
    }

    public int saveCity(City City) {
        return cityRepository.save(City);
    }

    public int updateCity(City City) {
        return cityRepository.update(City);
    }

    public int deleteCityById(int id) {
        return cityRepository.deleteById(id);
    }

    public int deleteAllCities() {
        return cityRepository.deleteAll();
    }
}
