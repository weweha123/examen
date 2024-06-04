package edu.hneu.mjt.makarenko.ticket_1_15.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewBook;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @JsonIgnore
    private Author author;

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

    public Book(NewBook newBook, Author author) {
        this.author = author;
        this.title = newBook.getTitle();
        this.genre = newBook.getGenre();
        this.pages = newBook.getPages();
        this.published = newBook.getPublished();
        this.language = newBook.getLanguage();
    }

    public void update(NewBook newBook) {
        this.title = newBook.getTitle();
        this.genre = newBook.getGenre();
        this.pages = newBook.getPages();
        this.published = newBook.getPublished();
        this.language = newBook.getLanguage();
    }
}
