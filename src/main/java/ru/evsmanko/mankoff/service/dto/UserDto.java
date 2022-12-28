package ru.evsmanko.mankoff.service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {
    private String firstName;
    private String lastName;
    private String phone;
}
