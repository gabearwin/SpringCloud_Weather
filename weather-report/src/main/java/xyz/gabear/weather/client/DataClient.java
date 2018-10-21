package xyz.gabear.weather.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.gabear.weather.vo.City;
import xyz.gabear.weather.vo.WeatherResponse;

import java.util.List;

/**
 * Data Client.
 */
@FeignClient(name = "ZUUL", fallback = DataClientFallback.class)
public interface DataClient {
    /**
     * 获取城市列表
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * 根据城市ID查询天气数据
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
