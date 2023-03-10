package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.PaymentEntity;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {
    List<PaymentEntity> allPayments();
    List<PaymentEntity> userPayments(Long userId);
    PaymentEntity savePayment(PaymentEntity payment);

}
