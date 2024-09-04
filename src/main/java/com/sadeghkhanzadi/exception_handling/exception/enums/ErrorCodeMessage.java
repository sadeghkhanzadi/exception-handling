package com.sadeghkhanzadi.exception_handling.exception.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.springframework.http.HttpStatusCode;

public enum ErrorCodeMessage {
    //Access
    access_denied("access denied", HttpStatusCode.valueOf(403),403),

    //Parameter
    parameter_absent("parameter absent", HttpStatusCode.valueOf(400),400),

    //invalid
    invalid_request("invalid request", HttpStatusCode.valueOf(400),400),
    invalid_param("invalid param", HttpStatusCode.valueOf(400),400),
    invalid_username("invalid username", HttpStatusCode.valueOf(400),400),
    invalid_phone_number("invalid phone number", HttpStatusCode.valueOf(400),400),
    invalid_verification("invalid verification", HttpStatusCode.valueOf(410),410),
    invalid_password("invalid password", HttpStatusCode.valueOf(400),400),
    invalid_grant("invalid grant", HttpStatusCode.valueOf(400),400), //When the provided token has either expired or is invalid.
    invalid_client_secret("invalid client secret", HttpStatusCode.valueOf(401),401), //Unauthorized-401 response indicates that access to the resource is restricted, and the request did not provide any HTTP authentication
    invalid_client("invalid client", HttpStatusCode.valueOf(401),401),
    invalid_token("invalid token", HttpStatusCode.valueOf(401),401), //When the provided token is invalid.
    invalid_format("invalid format", HttpStatusCode.valueOf(400),400),


    //NotFound
    account_not_found("account username not found", HttpStatusCode.valueOf(404),404),


    //Lock
    locked("locked", HttpStatusCode.valueOf(423), 423), //423 Locked
    identity_locked("identity locked", HttpStatusCode.valueOf(423), 423), //423 Identity Locked
    too_many_requests("too many requests",  HttpStatusCode.valueOf(429), 429), //429 Too Many Requests


    //Expired
    token_expired("token expired", HttpStatusCode.valueOf(401),401), //When the provided token is expired.
    link_expired("link expired", HttpStatusCode.valueOf(401),401), //When the provided token is expired.
    server_error("server error", HttpStatusCode.valueOf(500),500), //500 Internal Server Error


    //Conflict
    conflict("conflict", HttpStatusCode.valueOf(409),409), //409 Conflict
    conflict_username("repeated username", HttpStatusCode.valueOf(409),409),
    conflict_phone_number("repeated phone number ", HttpStatusCode.valueOf(409),409),
    conflict_email_address("repeated emailaddress", HttpStatusCode.valueOf(409),409),
    conflict_nationalCode("repeated nationalcode", HttpStatusCode.valueOf(409),409),

    //Not Checked Exception
    @JsonEnumDefaultValue
    UNKNOWN("Internal Server Error",  HttpStatusCode.valueOf(500),500)
    ;

    public String description;
    public HttpStatusCode http_status_code;

    public int http_custom_error_code;

    ErrorCodeMessage(String s, HttpStatusCode http_status_code, int http_custom_error_code) {
        this.description = s;
        this.http_status_code = http_status_code;
        this.http_custom_error_code = http_custom_error_code;
    }
}
