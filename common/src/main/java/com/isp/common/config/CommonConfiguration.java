package com.isp.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.isp.common")
@PropertySource("classpath:application.properties")
public class CommonConfiguration {
}
