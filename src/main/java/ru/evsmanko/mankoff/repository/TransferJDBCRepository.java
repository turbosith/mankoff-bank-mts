package ru.evsmanko.mankoff.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.Transfer;

import java.util.List;

@Repository
@AllArgsConstructor
public class TransferJDBCRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Transfer> findAll(){
        return jdbcTemplate.query(
                "SELECT * FROM TRANSFERS",
                new BeanPropertyRowMapper<>(Transfer.class)
        );
    }

    public List<Transfer> findBySenderId(Long id){
        return jdbcTemplate.query(
                "SELECT * FROM TRANSFERS WHERE SENDERID = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Transfer.class)
        );
    }

    public Transfer save(Transfer transfer){
        jdbcTemplate.update(
                "INSERT INTO TRANSFERS" +
                        "(SENDERID, RECEIVERID, DEPARTURETIME, AMOUNT)" +
                        "VALUES(? ? ? ?)",
                transfer.getSenderId(),
                transfer.getReceiverId(),
                transfer.getDepartureTime(),
                transfer.getAmount()
        );
        return transfer;
    }
}
