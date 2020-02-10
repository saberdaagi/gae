package com.isp.core.config;

import com.isp.common.config.CommonConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.isp.core")
@EntityScan("com.isp.core.domain")
@EnableJpaRepositories("com.isp.core.repository")
@PropertySource("classpath:config/application.properties")
@Import({ CommonConfiguration.class })
public class CoreConfig {
}
