package com.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerAllreadyExistException extends RuntimeException{

    public CustomerAllreadyExistException(String msg){
        super(msg);
    }
}
