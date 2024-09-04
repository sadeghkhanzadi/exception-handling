package com.sadeghkhanzadi.exception_handling.exception;

import org.springframework.http.HttpStatusCode;

import java.util.Date;

/**
 * Author : Sadegh Khanzadi
 * Email : khanzadisadegh@gmail.com
 * Tell: 09030908290
 * */
public class ErrorMessage {
    public HttpStatusCode http_status_code;
    public int http_custom_error_code;
    private Date timestamp;
    private String message;
    private String description;

    public ErrorMessage(){

    }

    private ErrorMessage(Builder builder) {
        this.http_status_code = builder.http_status_code;
        this.timestamp = builder.timestamp;
        this.message = builder.message;
        this.description = builder.description;
    }

    public static class Builder{
        public HttpStatusCode http_status_code = HttpStatusCode.valueOf(400);
        public int http_custom_error_code = 400;
        private Date timestamp = new Date();
        private String message;
        private String description;

        public Builder httpStatusCode(HttpStatusCode statusCode) {
            this.http_status_code = statusCode;
            return this;
        }

        public Builder http_custom_error_code(int customStatusCode) {
            this.http_custom_error_code = customStatusCode;
            return this;
        }

        public Builder timestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ErrorMessage builder(){
            return new ErrorMessage(this);
        }
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}