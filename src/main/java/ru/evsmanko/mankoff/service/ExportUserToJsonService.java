package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ExportUserToJsonService {
    private UserRepository userRepository;

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return new User();
    }
}