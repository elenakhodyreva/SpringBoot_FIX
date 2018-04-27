package ru.kai.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kai.service.forms.UserForm;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fix_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String birthDate;

    public static User from(UserForm form){
        return User.builder()
                .name(form.getName())
                .password(form.getPassword())
                .birthDate(form.getBirthDate())
                .build();
    }
}
