package com.luv2code.Ecommerce_Api_System.exception;

import com.luv2code.Ecommerce_Api_System.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiResponse<ErrorCode>> runtimeExceptionHandling(RuntimeException exception) {
        ApiResponse<ErrorCode> apiResponse = new ApiResponse<>();
        String message = exception.getMessage();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<ErrorCode>> invalidValueExceptionHandler(MethodArgumentNotValidException exception) {
        String messageError = exception.getFieldError().getDefaultMessage();
        ApiResponse<ErrorCode> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ErrorCode.INVALID_VALUE.getCode());
        apiResponse.setMessage(messageError);
        return ResponseEntity.badRequest().body(apiResponse);
    }


    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity<ApiResponse<ErrorCode>> productExistedExceptionHandler(ProductException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        log.info(exception.getMessage());
        return ResponseEntity.badRequest().body(
                ApiResponse.<ErrorCode>builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }


}