package edu.hneu.mjt.makarenko.ticket_1_15.controller;

import edu.hneu.mjt.makarenko.ticket_1_15.entity.Author;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewAuthor;
import edu.hneu.mjt.makarenko.ticket_1_15.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable UUID id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody NewAuthor author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable UUID id, @RequestBody NewAuthor author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable UUID id) {
        authorService.deleteAuthor(id);
    }
}
