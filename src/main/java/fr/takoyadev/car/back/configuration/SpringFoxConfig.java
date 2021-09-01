package fr.takoyadev.car.back.configuration;

import fr.takoyadev.car.back.properties.SpringFoxProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@RequiredArgsConstructor
public class SpringFoxConfig {

    public static final String TAG_CARS = "cars";
    public static final String TAG_LABELS = "labels";
    public static final String TAG_MAINTENANCES = "maintenances";
    public static final String TAG_OWNERS = "owners";
    public static final String TAG_ROLES = "roles";
    public static final String TAG_USERS = "users";

    @NonNull
    public SpringFoxProperties properties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(properties.getTitle())
                        .description(properties.getDescription())
                        .version(properties.getVersion())
                        .build())
                .tags(
                        new Tag(TAG_CARS, properties.getTags().get(TAG_CARS)),
                        new Tag(TAG_LABELS, properties.getTags().get(TAG_LABELS)),
                        new Tag(TAG_MAINTENANCES, properties.getTags().get(TAG_MAINTENANCES)),
                        new Tag(TAG_OWNERS, properties.getTags().get(TAG_OWNERS)),
                        new Tag(TAG_ROLES, properties.getTags().get(TAG_ROLES)),
                        new Tag(TAG_USERS, properties.getTags().get(TAG_USERS))
                )
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

}
