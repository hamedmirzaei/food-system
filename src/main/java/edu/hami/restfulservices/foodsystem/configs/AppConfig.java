package edu.hami.restfulservices.foodsystem.configs;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev, test"})
public class AppConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }

}
