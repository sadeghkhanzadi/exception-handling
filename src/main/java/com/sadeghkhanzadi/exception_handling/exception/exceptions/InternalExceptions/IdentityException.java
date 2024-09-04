package com.sadeghkhanzadi.exception_handling.exception.exceptions.InternalExceptions;

import com.sadeghkhanzadi.exception_handling.exception.ErrorMessage;
import com.sadeghkhanzadi.exception_handling.exception.enums.ErrorCodeMessage;
import com.sadeghkhanzadi.exception_handling.exception.exceptions.BaseException;
import org.springframework.http.HttpStatusCode;

public class IdentityException extends RuntimeException implements BaseException {

    private static final long serialVersionUID = 1450991358214077592L;

    private String error, error_description, state, reference_number;

    private Integer lockTime;
    public HttpStatusCode http_status_code;

    public int http_custom_error_code;
    private ErrorCodeMessage errorCodeMessage;

    public IdentityException(){

    }
    public IdentityException(ErrorCodeMessage errorCodeMessage,
                             String error_description,
                             String state,
                             Throwable cause,
                             String refNumber,
                             Integer lockTime) {
        super(error_description != null ? error_description : errorCodeMessage.description, cause);
        this.errorCodeMessage = errorCodeMessage;
        this.error = errorCodeMessage.name();
        if (error_description != null) {
            this.error_description = error_description;
        } else {
            this.error_description = errorCodeMessage.description;
        }
        this.state = state;
        this.http_status_code = errorCodeMessage.http_status_code;
        this.http_custom_error_code = errorCodeMessage.http_custom_error_code;
        this.reference_number = refNumber;
        this.lockTime = lockTime;
    }

    public IdentityException(ErrorCodeMessage errorCodeMessage) {
        this(errorCodeMessage, null, null, null, null, null);
    }

    public IdentityException(ErrorCodeMessage errorCodeMessage, String error_description) {
        this(errorCodeMessage, error_description, null, null, null, null);
    }

    public IdentityException(ErrorCodeMessage errorCodeMessage, String error_description, Integer lockTime) {
        this(errorCodeMessage, error_description, null, null, null, lockTime);
    }


    public IdentityException(ErrorCodeMessage errorCodeMessage, String error_description, Throwable cause) {
        this(errorCodeMessage, error_description, null, cause, null, null);
    }

    public IdentityException(ErrorCodeMessage errorCodeMessage, Throwable cause) {
        this(errorCodeMessage, null, null, cause, null, null);
    }

    public IdentityException(ErrorCodeMessage errorCodeMessage, String error_description, String state) {
        this(errorCodeMessage, error_description, state, null, null, null);
    }

    public IdentityException(ErrorCodeMessage errorCodeMessage, String error_description, String state, Throwable cause, String refNumber) {
        this(errorCodeMessage, error_description, state, cause, refNumber, null);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReference_number() {
        return reference_number;
    }

    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }

    public HttpStatusCode getHttp_status_code() {
        return http_status_code;
    }

    public void setHttp_status_code(HttpStatusCode http_status_code) {
        this.http_status_code = http_status_code;
    }

    public int getHttp_custom_error_code() {
        return http_custom_error_code;
    }

    public void setHttp_custom_error_code(int http_custom_error_code) {
        this.http_custom_error_code = http_custom_error_code;
    }

    public ErrorCodeMessage getErrorCodeMessage() {
        return errorCodeMessage;
    }

    public void setErrorCodeMessage(ErrorCodeMessage errorCodeMessage) {
        this.errorCodeMessage = errorCodeMessage;
    }


    @Override
    public ErrorMessage getErrorMessage(Throwable t) {
        return null;
    }
}
