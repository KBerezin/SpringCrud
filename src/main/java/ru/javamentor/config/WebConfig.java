package ru.javamentor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.javamentor.service.StringToLocalDateService;
import ru.javamentor.service.StringToUserRoleService;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public StringToUserRoleService stringToUserRoleService() {
        return new StringToUserRoleService();
    }

    @Bean
    public StringToLocalDateService stringToLocalDateService() {
        return new StringToLocalDateService();
    }

    public void addFormatters(final FormatterRegistry registry) {
        registry.addConverter(stringToUserRoleService());
        registry.addConverter(stringToLocalDateService());
    }
}