package mtsbank.evdokimov.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("mtsbank.evdokimov.controller")
@EnableWebMvc
public class SpringMVCConfiguration implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

    @Autowired
    public SpringMVCConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Bean
    public SpringResourceTemplateResolver
}
