package ru.kai.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.service.models.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
