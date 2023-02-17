package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.UserInfoEntity;


import java.util.List;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long> {
}
