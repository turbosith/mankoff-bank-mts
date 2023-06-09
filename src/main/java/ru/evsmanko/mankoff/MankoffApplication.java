package ru.evsmanko.mankoff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ru")
public class MankoffApplication {

    public static void main(String[] args) {
        SpringApplication.run(MankoffApplication.class, args);
    }

}
