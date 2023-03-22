package pl.gg.reklamy_zabd_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.dto.CityDto;
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

    public int saveCity(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    public int updateCity(CityDto dto) {
        City update = cityRepository.findById(dto.getId());
        if(dto.getPopulation()!=0)
            update.setPopulation(dto.getPopulation());
        return cityRepository.update(dto);
    }

    public int deleteCityById(int id) {
        return cityRepository.deleteById(id);
    }

    public int deleteAllCities() {
        return cityRepository.deleteAll();
    }
}
