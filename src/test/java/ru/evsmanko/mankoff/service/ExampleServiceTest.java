package ru.evsmanko.mankoff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.evsmanko.mankoff.dto.UserDto;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.mapping.UserMapper;
import ru.evsmanko.mankoff.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class ExampleServiceTest {

	@Mock
	private UserRepository repository;
	
	@Mock
	private UserMapper mapper;
	
	@InjectMocks
	private ExampleService service;
	
	@Test
	void testGetUsers() {
		when(repository.findAll())
				.thenReturn(Arrays.asList(new User().setId(1)));
		when(mapper.mapUserToDto(any(User.class))).thenCallRealMethod();
		
		List<UserDto> allUsers = service.getUsers();
		assertEquals(1, allUsers.size());
	}
}
