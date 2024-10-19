package com.scaler.bookmyshowfeb23.exception;

import com.scaler.bookmyshowfeb23.models.ShowSeat;

public class ShowSeatNotAvailableException extends Exception {
    public ShowSeatNotAvailableException(Long showSeatId) {
        super("ShowSeat with id: " + showSeatId + " isn't available");
    }
}
