package com.luv2code.Ecommerce_Api_System.exception;

import com.luv2code.Ecommerce_Api_System.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomerException extends AppException{

    public CustomerException(ErrorCode errorCode) {
        super(errorCode);
    }

    @ExceptionHandler(value = CustomerException.class)
    public ResponseEntity<ApiResponse<ErrorCode>> customerExceptionHandler(CustomerException exception){
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse<ErrorCode> apiResponse = new ApiResponse<>();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
