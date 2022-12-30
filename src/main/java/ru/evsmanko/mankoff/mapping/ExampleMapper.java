package ru.evsmanko.mankoff.mapping;

import org.springframework.stereotype.Component;

import ru.evsmanko.mankoff.dto.ExampleDto;
import ru.evsmanko.mankoff.entity.User;

@Component
public class ExampleMapper {
	
	public ExampleDto mapUserToDto(User user) {
		return new ExampleDto()
				.setFirstName(user.getFirstName())
				.setId(user.getId())
				.setLastName(user.getLastName())
				.setPhone(user.getPhone());
	}
}
