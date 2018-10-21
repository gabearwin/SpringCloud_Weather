package xyz.gabear.weather.service.impl;

import org.springframework.stereotype.Service;
import xyz.gabear.weather.service.CityDataService;
import xyz.gabear.weather.util.XmlBuilder;
import xyz.gabear.weather.vo.City;
import xyz.gabear.weather.vo.CityList;

import java.util.List;

/**
 * City Data Service.
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        CityList cityList = XmlBuilder.xmlToObject("static/cityList.xml", CityList.class);
        return cityList.getCityList();
    }

}
