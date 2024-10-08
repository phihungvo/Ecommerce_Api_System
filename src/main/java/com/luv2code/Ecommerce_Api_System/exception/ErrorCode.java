package com.luv2code.Ecommerce_Api_System.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public enum ErrorCode {
    UNCATEGORIZED(9999, "Uncategorized", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1000, "User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1001, "User not existed", HttpStatus.NOT_FOUND),
    INVALID_VALUE(1002, "", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUND(1003, "Product not found", HttpStatus.NOT_FOUND),
    PRODUCT_EXISTED(1004, "Product existed", HttpStatus.BAD_REQUEST),
    SELLER_EXISTED(1005, "Seller existed", HttpStatus.BAD_REQUEST),
    SELLER_NOT_FOUND(1006, "Seller not found", HttpStatus.NOT_FOUND),
    ;


    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    int code;
    String message;
    HttpStatusCode httpStatusCode;
}
