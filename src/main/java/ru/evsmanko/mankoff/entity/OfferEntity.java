package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="OFFERS")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "HEADING")
    private String heading;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "USERID")
    private Long user;


}
