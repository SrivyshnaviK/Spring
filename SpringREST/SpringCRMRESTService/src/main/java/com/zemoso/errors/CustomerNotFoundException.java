package com.zemoso.errors;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    public CustomerNotFoundException(Throwable cause){
        super(cause);
    }
    public CustomerNotFoundException(String message){
        super(message);
    }
}
