package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.dto.CityDto;
import pl.gg.reklamy_zabd_be.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping("/list")
    public String getAllCities(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "cities_list";
    }

    @GetMapping("/{id}")
    public String getCityById(Model model, @PathVariable int id) {
        City city = cityService.getCityById(id);
        model.addAttribute("city", city);
        return "city_edit";
    }

    @GetMapping("/form")
    public String cityForm(Model model) {
        model.addAttribute("city",new City());
        return "city_form";
    }

    @PutMapping("/{id}")
    public String updateCity(@Valid @ModelAttribute("city") CityDto city,
                             Model model, Errors errors) {
        if(errors.hasErrors()) return "city_edit";
        cityService.updateCity(city);
        model.addAttribute("city", city);
        return "redirect:/cities/list";
    }

    @PostMapping
    public String addCity(@Valid City city) {
        cityService.saveCity(city);
        return "redirect:/cities/list";
    }

    @DeleteMapping("/{id}")
    public String deleteCityById(@PathVariable int id) {
        cityService.deleteCityById(id);
        return "redirect:/cities/list";
    }

    @DeleteMapping
    public String deleteAllCities() {
        cityService.deleteAllCities();
        return "redirect:index";
    }

}
