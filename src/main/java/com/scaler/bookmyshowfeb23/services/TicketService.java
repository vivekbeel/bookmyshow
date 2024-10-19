package com.scaler.bookmyshowfeb23.services;

import com.scaler.bookmyshowfeb23.exception.ShowSeatNotAvailableException;
import com.scaler.bookmyshowfeb23.models.*;
import com.scaler.bookmyshowfeb23.repository.ShowSeatRepository;
import com.scaler.bookmyshowfeb23.repository.TicketRepository;
import com.scaler.bookmyshowfeb23.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    private TicketRepository ticketRepository;


    @Autowired //Not mandatory after spring 4.3
    TicketService(ShowSeatRepository showSeatRepository, UserRepository userRepository, TicketRepository ticketRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE) // lock is already there
    public Ticket bookTicket(List<Long> showSeatIds, Long userId) throws ShowSeatNotAvailableException {
        //Actual work for booking the ticket will come here.

        //Steps to book a ticket.
        //1. Fetch Show Seats from DB with the set of given showSeatIds.
        //showSeatIds -> (4, 5, 6, 7)
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds); // FOR UPDATE -> USER-2

        //2. Check the status of ShowSeats.
        //3. If any of them is NOT AVAILABLE then throw an exception.
        for (ShowSeat showSeat: showSeats) {
            if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                throw new ShowSeatNotAvailableException(showSeat.getId());
            }
        }

        //If all the seats are available.
        //4. Take a lock.
        //5. Check the status again if all the ShowSeats are available or not.
        //6. Proceed with the booking.
        //DOUBLE CHECK LOCKING.

        for (ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.LOCKED); // -> User-1 -> LOCKED.
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            //throw an Exception.
        }
        ticket.setBookedBy(optionalUser.get());
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setShowSeats(showSeats);

        // Ticket has been generated on the backend, now we need to navigate
        // to Payment page to complete the payment.
        // And once the payment is successful then the ticket status
        // will changed from PENDING to SUCCESS.

        return ticket;
    }

}
