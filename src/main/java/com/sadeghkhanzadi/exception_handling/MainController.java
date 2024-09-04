package com.sadeghkhanzadi.exception_handling;

import com.sadeghkhanzadi.exception_handling.exception.enums.ErrorCodeMessage;
import com.sadeghkhanzadi.exception_handling.exception.exceptions.InternalExceptions.OauthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/ok")
    public ResponseEntity<?> normalService(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/exeptionNotHandler")
    public ResponseEntity<?> exceptionNotHandlerService(){
        exceptionNotHandlerMethod();
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/exeptionHandler")
    public ResponseEntity<?> exceptionHandlerService(){
        exceptionHandlerMethod();
        return ResponseEntity.ok("OK");
    }

    public void exceptionNotHandlerMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("not handler exception");
    }

    public void exceptionHandlerMethod(){
        throw new OauthException(ErrorCodeMessage.access_denied , "User Not Access");
    }
}
