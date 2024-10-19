package com.scaler.bookmyshowfeb23.dto;

import com.scaler.bookmyshowfeb23.models.ResponseStatus;
import com.scaler.bookmyshowfeb23.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // Lombok
public class BookTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
