package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="offers")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heading;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
