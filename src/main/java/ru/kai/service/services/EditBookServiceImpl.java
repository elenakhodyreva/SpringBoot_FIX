package ru.kai.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kai.service.forms.BookForm;
import ru.kai.service.models.Book;
import ru.kai.service.repositories.BooksRepository;

@Service
public class EditBookServiceImpl implements EditBookService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public void saveNewBook(BookForm bookForm) {

        Book book= Book.builder()
                    .name(bookForm.getName())
                    .author(bookForm.getAuthor())
                    .count(bookForm.getCount())
                    .cost(bookForm.getCost())
                    .build();

        booksRepository.save(book);
    }
}
