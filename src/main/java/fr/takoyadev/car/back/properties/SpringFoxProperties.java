package fr.takoyadev.car.back.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "swagger")
public class SpringFoxProperties {

    private String description;
    private Map<String, String> tags;
    private String title;
    private String version;

}
