package ru.evsmanko.mankoff.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.evsmanko.mankoff.dto.UserDto;
import ru.evsmanko.mankoff.service.ExampleService;

@RestController
@RequiredArgsConstructor
public class ExampleController {

	private final ExampleService exampleService;
	
	@GetMapping("users")
	public List<UserDto> getAllUsers() {
		return exampleService.getUsers();
	}
}
