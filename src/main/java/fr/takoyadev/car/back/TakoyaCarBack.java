package fr.takoyadev.car.back;

import fr.takoyadev.car.back.properties.SpringFoxProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringFoxProperties.class)
public class TakoyaCarBack {

    public static void main(final String[] args) {
        SpringApplication.run(TakoyaCarBack.class, args);
    }

}
