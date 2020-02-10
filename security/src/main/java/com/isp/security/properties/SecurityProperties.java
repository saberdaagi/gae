package com.isp.security.properties;

import com.isp.core.constants.GrantType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static com.isp.core.constants.GrantType.*;

@ConfigurationProperties("retropac.security.oauth2")
@Data
public class SecurityProperties {

    /** Client ID. */
    String clientId = "retropac";

    /** Client Secret. */
    String clientSecret = "secret";

    /** JWT Signing Key. */
    String jwtSigningKey = "retropac";

    /** Access Token Validity Seconds. */
    int accessTokenValiditySeconds = (int) TimeUnit.HOURS.toSeconds(12);

    /** Refresh Token Validaity Seconds. */
    int refreshTokenValidaitySeconds = (int) TimeUnit.DAYS.toSeconds(30);

    /** Authorized Grant Types. */
    GrantType[] authorizedGrantTypes = {
        AUTHOTIZATION_CODE,
        IMPLICIT,
        PASSWORD,
        REFRESH_TOKEN
    };



    /** Resource ID. */
    String resourceId = "api/v1";

    public String[] getAuthorizedGrantTypes() {
        return Arrays.stream(authorizedGrantTypes)
                     .map(GrantType::toString)
                     .toArray(String[]::new);
    }



}
