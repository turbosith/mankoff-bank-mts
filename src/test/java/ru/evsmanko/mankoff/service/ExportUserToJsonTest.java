package ru.evsmanko.mankoff.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;

import java.util.NoSuchElementException;

@SpringBootTest
public class ExportUserToJsonTest {
    @Autowired
    private ExportUserToJsonService exportUserToJsonService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFirstUser() {
        var expected = userRepository.getUserById(1);
        var actual = exportUserToJsonService.getUser("1");
        Assertions.assertEquals(expected, actual);
    }
}
