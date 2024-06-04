package edu.hneu.mjt.makarenko.ticket_1_15.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class NewBook {
    private String title;

    private String genre;

    private int pages;

    private Date published;

    private String language;
}
