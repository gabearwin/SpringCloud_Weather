package xyz.gabear.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * City.
 */
@XmlRootElement(name = "d") // xml根元素
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class City {
    @XmlAttribute(name = "d1") // 根据属性映射
    private String cityId;

    @XmlAttribute(name = "d2")
    private String cityName;

    @XmlAttribute(name = "d3")
    private String cityCode;

    @XmlAttribute(name = "d4")
    private String province;

}
