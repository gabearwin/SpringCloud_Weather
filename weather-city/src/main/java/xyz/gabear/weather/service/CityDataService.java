package xyz.gabear.weather.service;

import xyz.gabear.weather.vo.City;

import java.util.List;

/**
 * City Data Service.
 */
public interface CityDataService {

    /**
     * 获取City列表
     */
    List<City> listCity() throws Exception;
}
