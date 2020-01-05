package com.teckup.api.config;


import com.teckup.core.config.CoreConfig;
import com.teckup.security.config.SecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        CoreConfig.class,
        SecurityConfiguration.class
})
public class ApiConfig {
}
