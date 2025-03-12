package com.motoshkin.apptrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.motoshkin.apptrack.models")
@EnableJpaRepositories("com.motoshkin.apptrack.repository")
public class ApptrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApptrackApplication.class, args);
    }

}
