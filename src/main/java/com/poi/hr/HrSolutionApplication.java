package com.poi.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HrSolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrSolutionApplication.class, args);
    }

}
