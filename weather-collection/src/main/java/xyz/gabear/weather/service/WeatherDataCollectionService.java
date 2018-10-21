package xyz.gabear.weather.service;

/**
 * Weather Data Collection Service.
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     */
    void syncDateByCityId(String cityId);
}
