package xyz.gabear.weather.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import xyz.gabear.weather.client.CityClient;
import xyz.gabear.weather.service.WeatherDataCollectionService;
import xyz.gabear.weather.vo.City;

import java.util.List;

/**
 * Weather Data Sync Job.
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService collectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表
        try {
            List<City> cityList = cityClient.listCity();
            // 遍历城市ID获取天气
            for (City city : cityList) {
                String cityId = city.getCityId();
                log.info("Weather Data Sync Job, cityId:" + cityId);
                collectionService.syncDateByCityId(cityId);
            }
        } catch (Exception e) {
            log.error("获取城市列表异常!", e);
        }
        log.info("Weather Data Sync Job. End！");
    }

}
