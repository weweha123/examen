package edu.hneu.mjt.makarenko.ticket_1_15.entity;

import edu.hneu.mjt.makarenko.ticket_1_15.model.NewAuthor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> books;

    public Author(NewAuthor newAuthor) {
        this.name = newAuthor.getName();
        this.nationality = newAuthor.getNationality();
        this.birthday = newAuthor.getBirthday();
        this.biography = newAuthor.getBiography();
        this.email = newAuthor.getEmail();
    }
}
