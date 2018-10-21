package xyz.gabear.weather.service;

import xyz.gabear.weather.vo.Weather;

/**
 * Weather Report Service.
 */
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     */
    Weather getDataByCityId(String cityId);
}
