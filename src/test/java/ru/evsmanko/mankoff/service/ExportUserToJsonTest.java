package ru.evsmanko.mankoff.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.dto.UserMapper;
import ru.evsmanko.mankoff.service.dto.UserDto;



@SpringBootTest
public class ExportUserToJsonTest {
    @Autowired

    private ExportUserToJsonService exportUserToJsonService;
    @Autowired

    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    @Test
    public void testFirstUser() {
        Long id = 1L;
        var expected = userRepository.getUserById(id);
        var actual = exportUserToJsonService.getUser(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThirdUserDtoCreation() {
        Long id = 3L;

        var thirdUser = userRepository.getUserById(id);
        var user = exportUserToJsonService.getUser(id);

        Mockito.when(userMapper.toDto(thirdUser))
                .thenReturn(new UserDto(user.getFirstName(),
                        user.getLastName(), user.getPhone()));
    }
}
