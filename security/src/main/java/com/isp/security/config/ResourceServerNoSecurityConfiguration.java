package com.isp.security.config;

import com.isp.security.properties.SecurityProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@Profile("!security")
@EnableResourceServer
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResourceServerNoSecurityConfiguration extends ResourceServerConfigurerAdapter {

    final SecurityProperties securityProperties;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(securityProperties.getResourceId());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()

            .headers()
            .frameOptions()
            .sameOrigin()
            .disable()

            .authorizeRequests()

            .anyRequest()
            .permitAll();
    }

}
