package ru.evsmanko.mankoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class OfferDTO {
    private Long id;
    private String heading;
    private String description;
    private Long user;
}
