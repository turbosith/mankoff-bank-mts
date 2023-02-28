package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.OfferEntity;

import java.util.List;


/**
 * Репозиторий офферов для клиента
 */
@Repository
public interface OfferRepository extends CrudRepository<OfferEntity, Long> {
    List<OfferEntity> findByUser(long userId);
}
