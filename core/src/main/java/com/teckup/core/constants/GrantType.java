package com.teckup.core.constants;

import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public enum GrantType {

    AUTHOTIZATION_CODE("authotization_code"),
    CLIENT_CREDENTIALS("client_credentials"),
    IMPLICIT("implicit"),

    /**
     * The access token request will contain the following parameters:
     *
     * grant_type (required) – The grant_type parameter must be set to “password”.
     * username (required) – The user’s username.
     * password (required) – The user’s password.
     * scope (optional) – The scope requested by the application.
     * { client_id, client_secret } (required if the client was issued a secret) - Client Authentication.
     *
     * Example:
     * <p>
     * POST /oauth/token HTTP/1.1
     * Host: authorization-server.com
     * Content-type: application/x-www-form-urlencoded
     *
     * grant_type=password
     * &username=exampleuser
     * &password=1234luggage
     * &client_id=xxxxxxxxxx
     * &client_secret=xxxxxxxxxx
     * </p>
     */
    PASSWORD("password"),

    /**
     * The access token request will contain the following parameters:
     *
     * grant_type (required) - The grant_type parameter must be set to “refresh_token”.
     * refresh_token (required) - The refresh token previously issued to the client.
     *
     * scope (optional) - The requested scope must not include additional scopes
     * that were not issued in the original access token.
     * Typically this will not be included in the request, and if omitted,
     * the service should issue an access token with the same scope as was previously issued.
     *
     * { client_id, client_secret } (required if the client was issued a secret) - Client Authentication
     *
     * <p>
     * POST /oauth/token HTTP/1.1
     * Host: authorization-server.com
     *
     * grant_type=refresh_token
     * &refresh_token=xxxxxxxxxxx
     * &client_id=xxxxxxxxxx
     * &client_secret=xxxxxxxxxx
     * </p>
     */
    REFRESH_TOKEN("refresh_token");

    final String value;

    @Override
    public String toString() {
        return value;
    }

}
