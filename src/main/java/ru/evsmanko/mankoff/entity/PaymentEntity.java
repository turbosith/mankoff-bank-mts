package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Long customerId;

    @Column(name="mcc_code")
    private int mccCode;

    @Column(name="amount")
    private int amount;

    @Column(name = "timestamp")
    private Timestamp time;


}
