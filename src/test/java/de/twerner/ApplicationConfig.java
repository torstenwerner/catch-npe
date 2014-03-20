package de.twerner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("de.twerner")
@EnableAspectJAutoProxy
public class ApplicationConfig {
    @Bean
    public Helper helper() {
        return new Helper();
    }
}
