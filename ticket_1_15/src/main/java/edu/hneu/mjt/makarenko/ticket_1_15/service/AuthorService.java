package edu.hneu.mjt.makarenko.ticket_1_15.service;

import edu.hneu.mjt.makarenko.ticket_1_15.entity.Author;
import edu.hneu.mjt.makarenko.ticket_1_15.model.NewAuthor;
import edu.hneu.mjt.makarenko.ticket_1_15.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(UUID id) {
        return authorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Author with id " + id + " not found!"));
    }

    public Author createAuthor(NewAuthor newAuthor) {
        return authorRepository.save(new Author(newAuthor));
    }

    public Author updateAuthor(UUID id, NewAuthor newAuthor) {
        var author = getAuthorById(id);
        author.setName(newAuthor.getName());
        author.setNationality(newAuthor.getNationality());
        author.setEmail(newAuthor.getEmail());
        author.setBirthday(newAuthor.getBirthday());
        author.setBiography(newAuthor.getBiography());
        return authorRepository.save(author);
    }

    public void deleteAuthor(UUID id) {
        var author = getAuthorById(id);
        authorRepository.delete(author);
    }
}
