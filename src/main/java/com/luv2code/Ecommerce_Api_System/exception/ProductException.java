package com.luv2code.Ecommerce_Api_System.exception;

import com.luv2code.Ecommerce_Api_System.dto.response.ApiResponse;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
public class ProductException extends RuntimeException{

    private ErrorCode errorCode;

    public ProductException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ProductException(String message, ErrorCode errorCode) {
        //super(message);
        this.errorCode = errorCode;
    }
}
