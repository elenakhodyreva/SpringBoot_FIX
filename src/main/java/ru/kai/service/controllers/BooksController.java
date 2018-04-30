package ru.kai.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kai.service.forms.BookForm;
import ru.kai.service.models.Author;
import ru.kai.service.models.Book;
import ru.kai.service.repositories.AuthorRepository;
import ru.kai.service.repositories.BooksRepository;
import ru.kai.service.security.details.UserDetailsImpl;
import ru.kai.service.transfer.UserDto;

import java.util.Optional;

import static ru.kai.service.transfer.UserDto.from;

@Controller
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorRepository authorRepository;

    //(READ)
    @GetMapping("/books")
    public String getBooksPage(ModelMap model, Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            UserDto user = from(details.getUser());
            model.addAttribute("user", user);
        }
        model.addAttribute("booksFromServer", booksRepository.findAll());
        return "books";
    }

    //создать новую книгу и сохранить в БД (CREATE)
    @PostMapping("/books")
    public String saveBook(BookForm bookForm) {

        //сначала проверить, есть ли уже книга с таким названием
        Optional<Book> bookCandidate = booksRepository.findOneByName(bookForm.getName());

        //если нет такой, создать, иначе ничего не делаем
        if (!bookCandidate.isPresent()) {
            //пробуем найти автора по имени
            Optional<Author> authorCandidate = authorRepository.findOneByAuthorName(bookForm.getAuthor());
            Author author;
            //если такого нет, создать автора
            if (!authorCandidate.isPresent()) {
                author = Author.builder()
                        .authorName(bookForm.getAuthor())
                        .build();
                authorRepository.save(author);
            } else {
                author = authorCandidate.get();
            }
            //создать книгу с этим автором, найденным ранее или только что созданным
            Book book = Book.builder()
                    .name(bookForm.getName())
                    .author(author)
                    .count(bookForm.getCount())
                    .cost(bookForm.getCost())
                    .build();

            //сохранить книгу в БД
            booksRepository.save(book);
        }
        return "redirect:books";
    }

    //удалить книгу по id (DELETE)
    @PostMapping(path = "/books", params = "del")
    public String deleteBook(BookForm bookForm) {

        booksRepository.delete(bookForm.getId());
        return "redirect:books";
    }

    //обновление стоимости (UPDATE)
    @PostMapping(path = "/books", params = "upd")
    public String update(BookForm bookForm) {

        Book book;
        //делаю через save, так как update не выполняется
        Optional<Book> bookCandidate = booksRepository.findOneByName(bookForm.getName());
        //обновить, если книга с таким именем существует, иначе ничего не делаем
        if (bookCandidate.isPresent()) {

            book = Book.builder()
                    //id и другое новому объекту присвоить из найденной книги
                    .id(bookCandidate.get().getId())
                    .name(bookCandidate.get().getName())
                    .author(bookCandidate.get().getAuthor())
                    .count(bookCandidate.get().getCount())
                    //новая стоимость из формы
                    .cost(bookForm.getCost())
                    .build();
            booksRepository.save(book);
        }
        return "redirect:books";
    }
}
