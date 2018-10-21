package xyz.gabear.weather.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xyz.gabear.weather.service.WeatherDataService;
import xyz.gabear.weather.utils.JsonUtil;
import xyz.gabear.weather.vo.WeatherResponse;

import javax.validation.constraints.NotNull;

/**
 * WeatherDataService 实现.
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(@NotNull String uri) {
        String strBody = null;

        // 先查缓存，缓存有的取缓存中的数据
        if (stringRedisTemplate.hasKey(uri)) {
            log.info("Redis has data");
            strBody = stringRedisTemplate.opsForValue().get(uri);
        } else {
            // 缓存没有，再调用服务接口来获取
            log.info("Redis has no data");
            // 缓存没有，抛出异常
            throw new RuntimeException("Redis has no data!");
        }

        return JsonUtil.toBean(strBody, WeatherResponse.class);
    }

}
