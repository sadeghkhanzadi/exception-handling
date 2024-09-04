package com.sadeghkhanzadi.exception_handling.exception.exceptions;

import com.sadeghkhanzadi.exception_handling.exception.ErrorMessage;
import com.sadeghkhanzadi.exception_handling.exception.enums.ErrorCodeMessage;
import com.sadeghkhanzadi.exception_handling.exception.exceptions.InternalExceptions.DbException;
import org.springframework.http.HttpStatusCode;

import java.util.Date;

public class UnCheckedExceptions {
    public static ErrorMessage getErrorMessage(Throwable ex) {
        ErrorMessage message = new ErrorMessage.Builder().builder();
        if (ex instanceof IllegalArgumentException) {//500 Error
            IllegalArgumentException exc = (IllegalArgumentException) ex;
            message = new ErrorMessage.Builder()
                    .message(exc.getMessage())
                    .timestamp(new Date())
                    .description(ErrorCodeMessage.UNKNOWN.description)
                    .httpStatusCode(HttpStatusCode.valueOf(500))
                    .http_custom_error_code(ErrorCodeMessage.UNKNOWN.http_custom_error_code)
                    .builder();
        } else if (ex instanceof ArrayIndexOutOfBoundsException) {//500 Error
            ArrayIndexOutOfBoundsException exc = (ArrayIndexOutOfBoundsException) ex;
            message = new ErrorMessage.Builder()
                    .message(exc.getMessage())
                    .timestamp(new Date())
                    .description(ErrorCodeMessage.UNKNOWN.description)
                    .httpStatusCode(HttpStatusCode.valueOf(500))
                    .http_custom_error_code(ErrorCodeMessage.UNKNOWN.http_custom_error_code)
                    .builder();
        } else if (ex instanceof NoClassDefFoundError) {//500 Error
            NoClassDefFoundError exc = (NoClassDefFoundError) ex;
            message = new ErrorMessage.Builder()
                    .message(exc.getMessage())
                    .timestamp(new Date())
                    .description(ErrorCodeMessage.UNKNOWN.description)
                    .httpStatusCode(HttpStatusCode.valueOf(500))
                    .http_custom_error_code(ErrorCodeMessage.UNKNOWN.http_custom_error_code)
                    .builder();
        } else if (ex instanceof IllegalThreadStateException) {//500 Error
            IllegalThreadStateException exc = (IllegalThreadStateException) ex;
            message = new ErrorMessage.Builder()
                    .message(exc.getMessage())
                    .timestamp(new Date())
                    .description(ErrorCodeMessage.UNKNOWN.description)
                    .httpStatusCode(HttpStatusCode.valueOf(500))
                    .http_custom_error_code(ErrorCodeMessage.UNKNOWN.http_custom_error_code)
                    .builder();
        } else if (ex instanceof DbException) {
            //todo constraint ex db status : 500
            message = new ErrorMessage.Builder().builder();
        } else {
            //todo logs
            message = new ErrorMessage.Builder().builder();
        }
        return message;
    }
}

