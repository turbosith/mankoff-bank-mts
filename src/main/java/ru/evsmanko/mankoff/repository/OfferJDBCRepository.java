package ru.evsmanko.mankoff.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.OfferEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
public class OfferJDBCRepository {
    private static final  String OFFERS = "SELECT * FROM OFFERS";
    private static final  String OFFERS_BY_ID = "SELECT * FROM OFFERS WHERE USERID = ?";
    private static final  String SAVE = "insert into OFFERS (HEADING, DESCRIPTION, USERID) values (?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;
    public List<OfferEntity> findAll(){
        return jdbcTemplate.query(
                OFFERS,
                new BeanPropertyRowMapper<>(OfferEntity.class)
        );
    }
    public List<OfferEntity> findAllByUserId(Long id){
        return jdbcTemplate.query(
                OFFERS_BY_ID,
                new Object[]{id},
                new BeanPropertyRowMapper<>(OfferEntity.class)
        );
    }

    public OfferEntity save(OfferEntity offer){
        jdbcTemplate.update(
                SAVE,
                offer.getHeading(),
                offer.getDescription(),
                offer.getUser()
        );
        return offer;
    }


}