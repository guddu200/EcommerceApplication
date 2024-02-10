package com.example.Ecommerce.exceptionHandling;

public class IdException extends Exception{
    private String errorMsg;

    public IdException(){

    }
    public IdException(String errorMsg){
        super(errorMsg);
        this.errorMsg=errorMsg;
    }

    public String getErrorMsg(){
        return errorMsg;
    }
}
