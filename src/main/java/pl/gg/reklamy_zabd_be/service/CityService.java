package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.dto.CityDto;
import pl.gg.reklamy_zabd_be.repository.CityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(int id) {
        return cityRepository.findById(id).orElseThrow();
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    public City updateCity(CityDto dto) {
        City update = cityRepository.findById(dto.getId()).orElseThrow();
        if(dto.getPopulation()!=0)
            update.setPopulation(dto.getPopulation());
        return cityRepository.save(update);
    }

    public void deleteCityById(int id) {
         cityRepository.deleteById(id);
    }

    public void deleteAllCities() {
         cityRepository.deleteAll();
    }
}
