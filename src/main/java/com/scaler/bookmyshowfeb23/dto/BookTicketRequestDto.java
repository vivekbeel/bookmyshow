package com.scaler.bookmyshowfeb23.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private List<Long> showSeatIds;
    private Long userId;
}
