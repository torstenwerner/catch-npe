package de.twerner;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@ComponentScan("de.twerner")
@EnableSpringConfigured
public class ApplicationConfig {
}
