package com.tiendinh.airbnb.exception;

import com.tiendinh.airbnb.model.error.ErrorCode;
import com.tiendinh.airbnb.model.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static com.tiendinh.airbnb.model.error.ErrorCode.DATA_DUPLICATED;
import static com.tiendinh.airbnb.model.error.ErrorCode.UNAUTHORIZED;

@Slf4j
public class AuthException extends BusinessLogicException {

    public AuthException(String message) {
        this(UNAUTHORIZED, message);
    }

    public AuthException(ErrorCode code, String message) {
        super(message, validationResponseError(code, message));
    }

    private static ErrorResponse validationResponseError(ErrorCode code, String message) {
        return ErrorResponse.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .code(String.valueOf(code))
                .message(message)
                .build();
    }

    public static AuthException requiredLogin() {
        return new AuthException(UNAUTHORIZED, "Required Login!");
    }

    public static AuthException usernameExists(String username) {
        log.error("AuthException usernameExists {}", username);
        return new AuthException(DATA_DUPLICATED, "username exists!");
    }

    public static AuthException emailExists(String email) {
        log.error("AuthException emailExists {}", email);
        return new AuthException(DATA_DUPLICATED, "email exists!");
    }
}
