package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.dto.CityDto;

import java.util.List;

public interface CityRepository {
    int save(City city);
    int update(CityDto city);
    City findById(int id);
    int deleteById(int id);
    List<City> findAll();
    int deleteAll();
}
