package ru.evsmanko.mankoff.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.evsmanko.mankoff.dto.ExampleDto;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.mapping.ExampleMapper;
import ru.evsmanko.mankoff.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ExampleService {

	private final UserRepository userRepository;
	
	private final ExampleMapper exampleMapper;
	
	public List<ExampleDto> getUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers.stream()
				.map(exampleMapper::mapUserToDto)
				.collect(Collectors.toList());
	}
}
