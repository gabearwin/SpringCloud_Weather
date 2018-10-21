package xyz.gabear.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.gabear.weather.service.CityDataService;
import xyz.gabear.weather.vo.City;

import java.util.List;

/**
 * Hello Controller.
 */
@RestController
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cities")
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
