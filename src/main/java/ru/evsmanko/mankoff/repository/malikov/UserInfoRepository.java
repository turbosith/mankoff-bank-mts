package ru.evsmanko.mankoff.repository.malikov;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.UserInfoEntity;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long> {
}
