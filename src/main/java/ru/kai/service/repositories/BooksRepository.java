package ru.kai.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kai.service.forms.BookForm;
import ru.kai.service.models.Book;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "update book b set b.cost=:cost where b.name=:name", nativeQuery = true)
    void updateBook(@Param("name") String name, @Param("cost") Integer cost);

    Optional<Book> findOneByName(String name);
}
