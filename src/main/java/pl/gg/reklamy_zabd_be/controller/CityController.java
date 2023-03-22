package pl.gg.reklamy_zabd_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = new ArrayList<>(cityService.getAllCities());
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable int id) {
        return cityService.getCityById(id);
    }

    @PutMapping
    public int updateCity(City City) {
        return cityService.updateCity(City);
    }

    @PostMapping
    public int addCity(City City) {
        return cityService.saveCity(City);
    }

    @DeleteMapping("/{id}")
    public int deleteCityById(@PathVariable int id) {
        return cityService.deleteCityById(id);
    }

    @DeleteMapping
    public int deleteAllCities() {
        return cityService.deleteAllCities();
    }

}
