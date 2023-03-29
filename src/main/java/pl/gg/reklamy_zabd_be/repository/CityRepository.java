package pl.gg.reklamy_zabd_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.Product;
import pl.gg.reklamy_zabd_be.pojo.dto.CityDto;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
//    int save(City city);
//    int update(CityDto city);
//    City findById(int id);
//    int deleteById(int id);
//    List<City> findAll();
//    int deleteAll();
}
