package xyz.gabear.weather.client;

import org.springframework.stereotype.Component;
import xyz.gabear.weather.vo.City;
import xyz.gabear.weather.vo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> listCity() throws Exception {
        List<City> cityList = new ArrayList<>();

        City city = new City();
        city.setCityId("101020100");
        city.setCityName("上海");
        cityList.add(city);

        city = new City();
        city.setCityId("101021300");
        city.setCityName("浦东");
        cityList.add(city);

        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
