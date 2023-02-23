package ru.evsmanko.mankoff.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.OfferEntity;

import java.util.List;

@Repository
@AllArgsConstructor
public class OfferJDBCRepository {
    private final JdbcTemplate jdbcTemplate;
    public List<OfferEntity> findAll(){
        return jdbcTemplate.query(
                "SELECT * FROM OFFERS",
                new BeanPropertyRowMapper<>(OfferEntity.class)
        );
    }
    public List<OfferEntity> findAllByUserId(Long id){
        return jdbcTemplate.query(
                "SELECT * FROM OFFERS WHERE USERID = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(OfferEntity.class)
        );
    }

    public OfferEntity save(OfferEntity offer){
        jdbcTemplate.update(
                "insert into OFFERS (HEADING, DESCRIPTION, USERID) values (?, ?, ?)",
                offer.getHeading(),
                offer.getDescription(),
                offer.getUser().getId()
        );
        return offer;
    }
}