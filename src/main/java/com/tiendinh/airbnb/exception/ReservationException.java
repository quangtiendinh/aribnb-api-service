package com.tiendinh.airbnb.exception;

import com.tiendinh.airbnb.model.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class ReservationException extends BusinessLogicException {

    public ReservationException(ErrorCode code, String message) {
        super(message, buildResponseError(code, message));
    }

    public ReservationException(int httpStatusCode, ErrorCode code, String message) {
        super(message, buildResponseError(httpStatusCode, code, message));
    }

    public static ReservationException reservationOverlapping() {
        return new ReservationException(HttpStatus.CONFLICT.value(), ErrorCode.DATA_DUPLICATED, "The reservation dates overlap with another reservation.");
    }

    public static ReservationException reservationConfirmed() {
        return new ReservationException(ErrorCode.DATA_DUPLICATED, "Canceled reservation cannot be confirmed.");
    }

    public static ReservationException reservationCanceled() {
        return new ReservationException(ErrorCode.DATA_DUPLICATED, "Canceled reservation cannot be confirmed.");
    }
}
