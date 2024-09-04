package com.sadeghkhanzadi.exception_handling.exception.exceptions;


import com.sadeghkhanzadi.exception_handling.exception.ErrorMessage;


/**
 * Author : Sadegh Khanzadi
 * Email : khanzadisadegh@gmail.com
 * Tell: 09030908290
 * */
public interface BaseException {
     ErrorMessage getErrorMessage(Throwable t);
}
