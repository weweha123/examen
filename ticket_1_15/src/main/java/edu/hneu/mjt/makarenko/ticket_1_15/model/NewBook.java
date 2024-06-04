package edu.hneu.mjt.makarenko.ticket_1_15.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class NewBook {
    @NotBlank
    private String title;

    @NotEmpty
    private String genre;

    @Positive
    private int pages;

    @PastOrPresent
    private Date published;

    @NotEmpty
    private String language;
}
