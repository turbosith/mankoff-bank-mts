package ru.evsmanko.mankoff.repository.malikov;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.UserInfoEntity;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserInfoJDBCRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<UserInfoEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM usersinfo", new BeanPropertyRowMapper<>(UserInfoEntity.class));
    }

    public UserInfoEntity findUserById(long id) {
        return jdbcTemplate.query("SELECT * FROM USERSINFO WHERE ID=?", new Object[]{id}, new BeanPropertyRowMapper<>(UserInfoEntity.class))
                .stream().findAny().orElse(null);
    }

    public void save(UserInfoEntity user) {
        jdbcTemplate.update("INSERT INTO USERSINFO(first_name, last_name, age, city) VALUES(?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(), user.getAge(), user.getCity());
    }
}
