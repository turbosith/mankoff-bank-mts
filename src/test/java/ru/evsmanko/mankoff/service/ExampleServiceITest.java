package ru.evsmanko.mankoff.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.evsmanko.mankoff.dto.ExampleDto;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;

@SpringBootTest
public class ExampleServiceITest {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ExampleService service;
	
	@Test
	void testGetUsers() {
		List<User> usersInDb = repository.findAll();
		List<ExampleDto> usersFromService = service.getUsers();
		
		usersInDb.forEach(u -> {
			assertTrue(usersFromService.stream().anyMatch(ufs -> {
				return u.getFirstName().equals(ufs.getFirstName())
						&& (u.getId() == ufs.getId())
						&& u.getLastName().equals(ufs.getLastName())
						&& u.getPhone().equals(ufs.getPhone());
			}));
		});
	}
}
