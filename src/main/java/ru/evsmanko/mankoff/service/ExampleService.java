package ru.evsmanko.mankoff.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.evsmanko.mankoff.dto.UserDto;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.mapping.UserMapper;
import ru.evsmanko.mankoff.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ExampleService {

	private final UserRepository userRepository;
	
	private final UserMapper userMapper;
	
	public List<UserDto> getUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers.stream()
				.map(userMapper::mapUserToDto)
				.collect(Collectors.toList());
	}
}