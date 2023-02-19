package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usersinfo")
@Accessors(chain = true)
public class UserInfoEntity {
    @Id
    private Long id;

    @NotEmpty(message = "should not be empty")
    @Size(min = 2, max = 30, message = "should be between 2 and 30 char")
    private String firstName;

    @NotEmpty(message = "should not be empty")
    @Size(min = 2, max = 30, message = "should be between 2 and 30 char")
    private String lastName;

    @NotNull
    @Min(value = 0, message = "should be greater than 0")
    private Long age;

    @NotEmpty(message = "should not be empty")
    @Size(min = 2, max = 30, message = "should be between 2 and 30 char")
    private String city;
}
