package com.isp.security.config;

import com.isp.common.config.CommonConfiguration;
import com.isp.security.properties.SecurityProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({ "com.isp.security" })
@EntityScan("org.retropac.security.model")
@EnableJpaRepositories("com.isp.security.repository")
@PropertySource("classpath:config/application.properties")
@EnableConfigurationProperties({ SecurityProperties.class })
@Import({
    CommonConfiguration.class
})
public class SecurityConfiguration {

}
