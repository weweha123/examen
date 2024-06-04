package edu.hneu.mjt.makarenko.ticket_1_15.repository;

import edu.hneu.mjt.makarenko.ticket_1_15.entity.Author;
import edu.hneu.mjt.makarenko.ticket_1_15.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
  Optional<Book> findByIdAndAuthor(UUID id, Author author);
}