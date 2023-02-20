package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date departureTime;
    @Column(name = "AMOUNT")
    private int amount;
}
