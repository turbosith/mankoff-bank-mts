package ru.evsmanko.mankoff.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExportUserToJsonService {
    private UserRepository userRepository;

    public User getUser(String strId) {
        try {
            Long id = Long.parseLong(strId);
            Optional<User> user = userRepository.findById(id);
            return user.get();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
        return new User();
    }
}