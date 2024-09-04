package com.sadeghkhanzadi.exception_handling.exception;

import com.sadeghkhanzadi.exception_handling.exception.exceptions.BaseException;
import com.sadeghkhanzadi.exception_handling.exception.exceptions.UnCheckedExceptions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionConfiguration extends ResponseEntityExceptionHandler {
    private static final String exceptionPath = "com.sadeghkhanzadi.exception_handling.exception.exceptions.InternalExceptions";
    private static Map<String, BaseException> baseExceptionMap = new HashMap<>();

    static {
        try {
            initBaseException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @ResponseBody
    @ExceptionHandler({Throwable.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> oauthException(
            Throwable ex, WebRequest request) {
        Class<? extends Throwable> aClass = ex.getClass();
        BaseException baseException = baseExceptionMap.get(aClass.getSimpleName());
        ErrorMessage message;
        if (baseException != null) {
            message = baseException.getErrorMessage(ex);
        } else {
            message = UnCheckedExceptions.getErrorMessage(ex);
        }
        //todo logs
        return new ResponseEntity<ErrorMessage>(message, new HttpHeaders(), message.getHttp_status_code());
    }

    private static void initBaseException() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<Class> classSet = findAllClassesUsingClassLoader(exceptionPath);
        for (Class i : classSet) {

            BaseException b = (BaseException) Class.forName(i.getName()).newInstance();
            System.out.println("Exception Class Name: " + i.getSimpleName());
            baseExceptionMap.put(
                    i.getSimpleName(),b
            );
        }
    }

    public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}
