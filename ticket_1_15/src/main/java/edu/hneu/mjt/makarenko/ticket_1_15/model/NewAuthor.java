package edu.hneu.mjt.makarenko.ticket_1_15.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class NewAuthor {
    @NotEmpty
    private String name;

    @NotEmpty
    private String nationality;

    @PastOrPresent(message = "Birthday cannot be in the future")
    private Date birthday;

    @Column(length = 5000)
    @Size(max = 5000)
    private String biography;

    @NotEmpty
    @Pattern(regexp="^[A-Za-z]+\\.[A-Za-z]+@hneu\\.net$",
            message="Invalid email format. Correct email format: <Name.Surmname>@hneu.net.")
    private String email;
}
