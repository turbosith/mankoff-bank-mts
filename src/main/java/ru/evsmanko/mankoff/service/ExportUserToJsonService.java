package ru.evsmanko.mankoff.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.properties.UserToJsonProperties;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExportUserToJsonService {
    private UserRepository userRepository;
    private final UserToJsonProperties userToJsonProperties;

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            var json = createJsonFromUser(user.get());
            saveUserJson(json, user.get().getId());
            return user.get();
        }
        return new User();
    }
    private String createJsonFromUser(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);
        return json;
    }
    private void saveUserJson(String json, Long id){
        try (PrintWriter out = new PrintWriter(
                userToJsonProperties.getPath()
                       + id.toString()  + userToJsonProperties.getName())) {
            out.println(json);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}