package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.Transfer;

import java.util.List;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {
    @Override
    List<Transfer> findAll();

    List<Transfer> findBySenderId(Long id);

    @Override
    <S extends Transfer> S save(S entity);
}