package edu.hneu.mjt.makarenko.ticket_1_15.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class NewAuthor {
    private String name;

    private String nationality;

    private Date birthday;

    private String biography;

    private String email;
}
