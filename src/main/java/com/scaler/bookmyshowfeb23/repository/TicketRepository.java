package com.scaler.bookmyshowfeb23.repository;

import com.scaler.bookmyshowfeb23.controllers.TicketController;
import com.scaler.bookmyshowfeb23.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket); //UPSERT

    Ticket save(List<Ticket> tickets);
}

//insert into tickets values (a,b,c), (x,y, z), (p,q,r) and so on.
