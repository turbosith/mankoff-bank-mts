package ru.evsmanko.mankoff.mapping;

import org.springframework.stereotype.Component;

import ru.evsmanko.mankoff.dto.UserDto;
import ru.evsmanko.mankoff.entity.User;

@Component
public class UserMapper {
	
	public UserDto mapUserToDto(User user) {
		return new UserDto()
				.setFirstName(user.getFirstName())
				.setId(user.getId())
				.setLastName(user.getLastName())
				.setPhone(user.getPhone());
	}
}
