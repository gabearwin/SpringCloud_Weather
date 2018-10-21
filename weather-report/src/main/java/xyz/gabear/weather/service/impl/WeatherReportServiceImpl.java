package xyz.gabear.weather.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.gabear.weather.client.DataClient;
import xyz.gabear.weather.service.WeatherReportService;
import xyz.gabear.weather.vo.Weather;
import xyz.gabear.weather.vo.WeatherResponse;

/**
 * Weather Report Service.
 */
@Service
@Slf4j
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse dataByCityId = dataClient.getDataByCityId(cityId);
        return dataByCityId.getData();
    }

}
