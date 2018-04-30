package ru.kai.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
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

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
    private Integer count;
    private Integer cost;

    public static Book from(BookForm form){
        return Book.builder()
                .name(form.getName())
                .count(form.getCount())
                .cost(form.getCost())
                .build();
    }
}
