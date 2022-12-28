package ru.evsmanko.mankoff.service.dto;

import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.entity.User;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        var firstName = user.getFirstName();
        var lastName = user.getLastName();
        var phone = user.getPhone();
        return new UserDto(firstName, lastName, phone);
    }
}
