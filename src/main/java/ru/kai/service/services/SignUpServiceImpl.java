package ru.kai.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kai.service.forms.UserForm;
import ru.kai.service.models.User;
import ru.kai.service.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void signUp(UserForm userForm) {

        User user = User.builder()
                .name(userForm.getName())
                .password(userForm.getPassword())
                .birthDate(userForm.getBirthDate())
                .build();
        usersRepository.save(user);
    }
}
