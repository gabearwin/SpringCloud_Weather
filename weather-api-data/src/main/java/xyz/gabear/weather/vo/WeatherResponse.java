package xyz.gabear.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Weather Response.
 */
@Data
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 6600760531692634918L;

    private Weather data;
    private Integer status;
    private String desc;
}
