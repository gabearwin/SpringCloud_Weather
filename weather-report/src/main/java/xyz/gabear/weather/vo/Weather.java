package xyz.gabear.weather.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息.
 */
@Data
public class Weather implements Serializable {
    private static final long serialVersionUID = 4429307645426486219L;

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
