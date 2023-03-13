package ru.evsmanko.mankoff.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.PaymentEntity;

import java.util.List;

@Repository
@AllArgsConstructor
public class PaymentJDBCRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<PaymentEntity> allPayments(){
        return jdbcTemplate.query(
                "select * from payments", new BeanPropertyRowMapper<>(PaymentEntity.class));
    }

    public List<PaymentEntity> userPayments(Long id){
        return jdbcTemplate.query(
                "select * from payments where customer_id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(PaymentEntity.class));
    }

    public PaymentEntity savePayment(PaymentEntity payment){
        jdbcTemplate.update(
                "insert into payments" +
                        "(id, customer_id, mcc_code, amount, time) values(?, ?, ?, ?, ?)",
        payment.getId(), payment.getCustomerId(), payment.getMccCode(), payment.getAmount(), payment.getTime()
		);
        return payment;
    }

}