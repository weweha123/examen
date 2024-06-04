package edu.hneu.mjt.makarenko.ticket_1_15.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewBook;
import jakarta.persistence.*;
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

    private String title;

    private String genre;

    private int pages;

    private Date published;

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
