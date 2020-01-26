package com.teckup.security.config;

import com.teckup.security.properties.SecurityProperties;
import com.teckup.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    final AuthenticationManager authenticationManager;

    final UserService userService;

    final JwtAccessTokenConverter accessTokenConverter;

    final PasswordEncoder passwordEncoder;

    final SecurityProperties securityProperties;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory()

            .withClient(securityProperties.getClientId())
            .secret(passwordEncoder.encode(securityProperties.getClientSecret()))

            .authorizedGrantTypes(securityProperties.getAuthorizedGrantTypes())


            .resourceIds(securityProperties.getResourceId())

            .accessTokenValiditySeconds(securityProperties.getAccessTokenValiditySeconds())
            .refreshTokenValiditySeconds(securityProperties.getRefreshTokenValidaitySeconds());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
            .accessTokenConverter(accessTokenConverter)
            .userDetailsService(userService)
            .authenticationManager(authenticationManager);
    }

}
