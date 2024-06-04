package edu.hneu.mjt.makarenko.ticket_1_15.controller;

import edu.hneu.mjt.makarenko.ticket_1_15.entity.Author;
import edu.hneu.mjt.makarenko.ticket_1_15.entity.Book;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewAuthor;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewBook;
import edu.hneu.mjt.makarenko.ticket_1_15.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/authors/{authorId}/books/{id}")
    public Book getBook(@PathVariable UUID authorId, @PathVariable UUID id) {
        return bookService.getBookByIdAndAuthorId(authorId, id);
    }

    @GetMapping("/authors/{authorId}/books/count")
    public int getBooksCount(@PathVariable UUID authorId) {
        return bookService.getBooksCountByAuthorId(authorId);
    }

    @PostMapping("/authors/{authorId}/books")
    public Book addBook(@PathVariable UUID authorId, @RequestBody NewBook newBook) {
        return bookService.createBook(authorId, newBook);
    }

    @PutMapping("/authors/{authorId}/books/{id}")
    public Book updateBook(@PathVariable UUID authorId, @PathVariable UUID id, @RequestBody NewBook newBook) {
        return bookService.updateBook(authorId, id, newBook);
    }

    @DeleteMapping("/authors/{authorId}/books/{id}")
    public void deleteBook(@PathVariable UUID authorId, @PathVariable UUID id) {
        bookService.deleteBook(authorId, id);
    }
}
