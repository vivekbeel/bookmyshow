package com.scaler.bookmyshowfeb23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int row;

    @Column(name = "col")
    private int column;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

}
