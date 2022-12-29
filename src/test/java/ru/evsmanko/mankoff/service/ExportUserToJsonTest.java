package ru.evsmanko.mankoff.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.dto.UserMapper;
import ru.evsmanko.mankoff.service.dto.UserDto;


@SpringBootTest
public class ExportUserToJsonTest {
    @Autowired

    private ExportUserToJsonService exportUserToJsonService;
    @Mock

    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFirstUser() {

        Mockito.when(userRepository.getUserById(1))
                .thenReturn(new User(1,"Евгений", "Манько", "79166679083"));

        var expected = userRepository.getUserById(1);
        var actual = exportUserToJsonService.getUser(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstUserDtoCreation() {
        Long id = 1L;

        Mockito.when(userRepository.getUserById(1))
                .thenReturn(new User(1,"Евгений", "Манько", "79166679083"));

        var thirdUser = userRepository.getUserById(id);
        var user = exportUserToJsonService.getUser(id);
        var actual = userMapper.toDto(thirdUser);
        var expected = new UserDto(user.getFirstName(),
                user.getLastName(), user.getPhone());

        Assertions.assertEquals(expected, actual);
    }
}
