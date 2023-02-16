package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private long age;
    private String city;
}
