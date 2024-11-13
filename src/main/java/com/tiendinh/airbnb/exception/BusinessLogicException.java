package com.tiendinh.airbnb.exception;

import com.tiendinh.airbnb.model.error.ErrorCode;
import com.tiendinh.airbnb.model.error.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

import static com.tiendinh.airbnb.model.error.ErrorCode.DATA_NOT_FOUND;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class BusinessLogicException extends RuntimeException implements Serializable {

    private ErrorResponse error;

    public BusinessLogicException(ErrorResponse error) {
        super(error.getMessage());
        this.error = error;
    }

    public BusinessLogicException(String message, ErrorResponse error) {
        super(message);
        this.error = error;
    }

    public BusinessLogicException(String message, ErrorResponse error, Throwable throwable) {
        super(message, throwable);
        this.error = error;
    }
    public static BusinessLogicException resourceNotFound(String message) {
        return new BusinessLogicException(buildResponseError(HttpStatus.NOT_FOUND.value(), DATA_NOT_FOUND, message));
    }

    public static BusinessLogicException resourceDuplicated(String message) {
        return new BusinessLogicException(buildResponseError(HttpStatus.CONTINUE.value(), DATA_NOT_FOUND, message));
    }

    public static ErrorResponse buildResponseError(ErrorCode code, String message) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code(String.valueOf(code))
                .message(message)
                .build();
    }

    public static ErrorResponse buildResponseError(int statusCode, ErrorCode code, String message) {
        return ErrorResponse.builder()
                .status(statusCode)
                .code(String.valueOf(code))
                .message(message)
                .build();
    }
}
