package com.scaler.bookmyshowfeb23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass // Schema Design
@Getter
@Setter
//@Entity -> Not required here because we don't want tot create the table for BaseModel.
public abstract class BaseModel {
    @Id // -> @Id denotes that this attribute is a PK of the table.
    @GeneratedValue(strategy = IDENTITY)

    //@Column(name = "identity")
    private Long id;
}
