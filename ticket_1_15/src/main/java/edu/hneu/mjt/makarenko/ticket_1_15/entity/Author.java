package edu.hneu.mjt.makarenko.ticket_1_15.entity;

import edu.hneu.mjt.makarenko.ticket_1_15.model.NewAuthor;
import jakarta.persistence.*;
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

    private String name;

    private String nationality;

    private Date birthday;

    @Column(length = 5000)
    private String biography;

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
