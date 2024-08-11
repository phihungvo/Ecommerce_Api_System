package com.luv2code.Ecommerce_Api_System.exception;

import lombok.Getter;

@Getter
public class SellerException extends RuntimeException{

    private ErrorCode errorCode;

    public SellerException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public SellerException(String message, ErrorCode errorCode) {
        //super(message);
        this.errorCode = errorCode;
    }
}
