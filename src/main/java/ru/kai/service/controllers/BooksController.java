package ru.kai.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.service.forms.BookForm;
import ru.kai.service.repositories.BooksRepository;
import ru.kai.service.security.details.UserDetailsImpl;
import ru.kai.service.services.EditBookService;
import ru.kai.service.transfer.UserDto;

import static ru.kai.service.transfer.UserDto.from;

@Controller
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private EditBookService editBookService;

    @GetMapping("/books")
    public String getBooksPage(ModelMap model, Authentication authentication){
        if(authentication!= null){
            UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
            UserDto user = from(details.getUser());
            model.addAttribute("user", user);
        }
        model.addAttribute("booksFromServer", booksRepository.findAll());
        return "books";
    }

    @PostMapping("/books")
    public String saveBook(BookForm bookForm){

        editBookService.saveNewBook(bookForm);
        return "redirect:books";
    }
}
