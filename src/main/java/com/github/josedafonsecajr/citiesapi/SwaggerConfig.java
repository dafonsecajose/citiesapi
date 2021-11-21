package com.github.josedafonsecajr.citiesapi;

import com.fasterxml.classmate.TypeResolver;
import com.github.josedafonsecajr.citiesapi.cities.properties.CityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.api.version}")
    private String versionApplication;

    @Autowired
    private TypeResolver resolver;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.josedafonsecajr.citiesapi"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo())
                .additionalModels(resolver.resolve(CityProperties.class)).useDefaultResponseMessages(false);
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Cities API")
                .description("API REST que busca cidades e calcula a distancia entre elas.")
                .version(versionApplication).build();
    }
}
