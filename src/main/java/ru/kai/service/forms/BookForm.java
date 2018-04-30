package ru.kai.service.forms;

import lombok.Data;

@Data
public class BookForm {
    private Long id;
    private String name;
    private String author;
    private Integer count;
    private Integer cost;
}
