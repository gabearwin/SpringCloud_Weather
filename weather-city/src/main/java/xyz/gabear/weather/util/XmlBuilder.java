package xyz.gabear.weather.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * Xml Builder.
 */
public class XmlBuilder {

    /**
     * 将XML转为指定的POJO
     */
    public static <T> T xmlToObject(String xmlFilePath, Class<T> clazz) throws Exception {

        // 读取XML文件
        Resource resource = new ClassPathResource(xmlFilePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuilder builder = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }
        br.close();

        JAXBContext context = JAXBContext.newInstance(clazz);
        // XML 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Reader reader = new StringReader(builder.toString());
        Object xmlObject = unmarshaller.unmarshal(reader);
        reader.close();

        return (T) xmlObject;
    }
}
