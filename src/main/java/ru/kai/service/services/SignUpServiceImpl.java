package ru.kai.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kai.service.forms.UserForm;
import ru.kai.service.models.Role;
import ru.kai.service.models.State;
import ru.kai.service.models.User;
import ru.kai.service.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {

        String hashPassword= passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .name(userForm.getName())
                .login(userForm.getLogin())
                .hashPassword(hashPassword)
                .birthDate(userForm.getBirthDate())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        usersRepository.save(user);
    }
}
