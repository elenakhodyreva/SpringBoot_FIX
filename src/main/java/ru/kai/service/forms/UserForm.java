package ru.kai.service.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserForm {
    private String name;
    private String password;
    private String birthDate;
}
