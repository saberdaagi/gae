package com.teckup.core.config;

import com.teckup.common.config.CommonConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.teckup.core")
@EntityScan("com.teckup.core.domain")
@EnableJpaRepositories("com.teckup.core.repository")
@PropertySource("classpath:config/application.properties")
@Import({ CommonConfiguration.class })
public class CoreConfig {
}
