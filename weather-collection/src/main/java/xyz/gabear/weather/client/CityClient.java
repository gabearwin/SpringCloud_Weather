package xyz.gabear.weather.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.gabear.weather.vo.City;

import java.util.List;

/**
 * City Client.
 */
@FeignClient("CITY")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
