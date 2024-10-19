package com.scaler.bookmyshowfeb23.controllers;

import com.scaler.bookmyshowfeb23.dto.BookTicketRequestDto;
import com.scaler.bookmyshowfeb23.dto.BookTicketResponseDto;
import com.scaler.bookmyshowfeb23.dto.CancelTicketRequestDto;
import com.scaler.bookmyshowfeb23.dto.CancelTicketResponseDto;
import com.scaler.bookmyshowfeb23.exception.ShowSeatNotAvailableException;
import com.scaler.bookmyshowfeb23.models.ResponseStatus;
import com.scaler.bookmyshowfeb23.models.Ticket;
import com.scaler.bookmyshowfeb23.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

   public BookTicketResponseDto bookTicket(BookTicketRequestDto requestDto) throws ShowSeatNotAvailableException {
       Ticket ticket = ticketService.bookTicket(
               requestDto.getShowSeatIds(),
               requestDto.getUserId()
       );

       BookTicketResponseDto responseDto = new BookTicketResponseDto();
       responseDto.setTicket(ticket);
       responseDto.setResponseStatus(ResponseStatus.SUCCESS);

       return responseDto;
    }

    public CancelTicketResponseDto cancelTicket(CancelTicketRequestDto requestDto) {
        return null;
    }
}

//Spring Framework -> Dependency Injection
