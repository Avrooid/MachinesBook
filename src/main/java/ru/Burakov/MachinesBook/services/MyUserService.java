package ru.Burakov.MachinesBook.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.Burakov.MachinesBook.models.MyUser;
import ru.Burakov.MachinesBook.repositories.MyUserRepository;
import ru.Burakov.MachinesBook.requests.RegisterRequest;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserService {
    private final MyUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()) == null) {
            var user = MyUser.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .enabled(true)
                    .role("ROLE_USER")
                    .build();
            userRepository.save(user);
            log.info("Saving new user with username: {}", user.getUsername());
        }
        // В будущем тут надо сделать проброс ошибки при условии существования юзера из запроса
    }
}
