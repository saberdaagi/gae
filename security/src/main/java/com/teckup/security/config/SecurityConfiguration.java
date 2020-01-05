package com.teckup.security.config;

import com.teckup.common.config.CommonConfiguration;
import com.teckup.security.properties.SecurityProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({ "com.teckup.security" })
@EntityScan("org.retropac.security.model")
@EnableJpaRepositories("com.teckup.security.repository")
@PropertySource("classpath:config/application.properties")
@EnableConfigurationProperties({ SecurityProperties.class })
@Import({
    CommonConfiguration.class
})
public class SecurityConfiguration {

}
