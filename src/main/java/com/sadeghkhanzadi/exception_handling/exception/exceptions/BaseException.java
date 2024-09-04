package com.sadeghkhanzadi.exception_handling.exception.exceptions;


import com.sadeghkhanzadi.exception_handling.exception.ErrorMessage;

public interface BaseException {
     ErrorMessage getErrorMessage(Throwable t);
}
