package ru.kai.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kai.service.forms.BookForm;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private Integer count;
    private Integer cost;

    public static Book from(BookForm form){
        return Book.builder()
                .name(form.getName())
                .author(form.getAuthor())
                .count(form.getCount())
                .cost(form.getCost())
                .build();
    }
}
