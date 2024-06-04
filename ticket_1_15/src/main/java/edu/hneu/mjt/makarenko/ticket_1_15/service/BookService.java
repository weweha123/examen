package edu.hneu.mjt.makarenko.ticket_1_15.service;

import edu.hneu.mjt.makarenko.ticket_1_15.entity.Author;
import edu.hneu.mjt.makarenko.ticket_1_15.entity.Book;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewAuthor;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewBook;
import edu.hneu.mjt.makarenko.ticket_1_15.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByIdAndAuthorId(UUID authorId, UUID id) {
        var author = authorService.getAuthorById(authorId);
        return bookRepository.findByIdAndAuthor(id, author).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, author.getName() + " doesn't have book with id " + id)
        );
    }

    public Book createBook(UUID authorId, NewBook newBook) {
        var author = authorService.getAuthorById(authorId);
        return bookRepository.save(new Book(newBook, author));
    }

    public Book updateBook(UUID authorId, UUID id, NewBook newBook) {
        var book = getBookByIdAndAuthorId(authorId, id);
        book.update(newBook);
        return bookRepository.save(book);
    }

    public void deleteBook(UUID authorId, UUID id) {
        var book = getBookByIdAndAuthorId(authorId, id);
        bookRepository.delete(book);
    }

    public int getBooksCountByAuthorId(UUID authorId) {
        var books = authorService.getAuthorById(authorId).getBooks();
        return books.size();
    }
}
