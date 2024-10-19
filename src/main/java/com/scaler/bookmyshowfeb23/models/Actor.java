package com.scaler.bookmyshowfeb23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity //Annotations.
@Getter
@Setter
public class Actor extends BaseModel {
    private String name;

    private int age;
}


// private attributes in a class.

//Lombok

//Spring Data JPA.