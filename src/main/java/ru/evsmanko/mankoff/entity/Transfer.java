package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name="TRANSFERS")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "SENDERID")
    private int senderId;
    @Column(name = "RECEIVERID")
    private int receiverId;
    @Column(name = "DEPARTURETIME")
    private Timestamp departureTime;
    @Column(name = "AMOUNT")
    private int amount;
}
