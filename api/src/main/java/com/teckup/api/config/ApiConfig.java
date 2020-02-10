package com.isp.api.config;


import com.isp.core.config.CoreConfig;
import com.isp.security.config.SecurityConfiguration;
import com.isp.task.scheduler.taskscheduler.config.SchedulerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.isp.api")
@Import({
        CoreConfig.class,
        SecurityConfiguration.class,
        SchedulerConfig.class
})
public class ApiConfig {
}
