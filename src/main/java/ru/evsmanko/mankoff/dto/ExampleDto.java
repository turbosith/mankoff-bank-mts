package ru.evsmanko.mankoff.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ExampleDto {

	private long id;
    private String firstName;
    private String lastName;
    private String phone;

}
