package ru.kai.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.service.forms.BookForm;
import ru.kai.service.repositories.BooksRepository;
import ru.kai.service.services.EditBookService;

@Controller
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private EditBookService editBookService;

    @GetMapping("/books")
    public String getBooksPage(ModelMap model){
        model.addAttribute("booksFromServer", booksRepository.findAll());
        return "books";
    }

    @PostMapping("/books")
    public String saveBook(BookForm bookForm){

        editBookService.saveNewBook(bookForm);
        return "redirect:books";
    }
}
