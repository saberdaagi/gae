package com.teckup.api.config;


import com.teckup.core.config.CoreConfig;
import com.teckup.security.config.SecurityConfiguration;
import com.teckup.task.scheduler.taskscheduler.config.SchedulerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.teckup.api")
@Import({
        CoreConfig.class,
        SecurityConfiguration.class,
        SchedulerConfig.class
})
public class ApiConfig {
}
