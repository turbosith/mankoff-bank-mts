package ru.evsmanko.mankoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class TransferDTO {
    private int id;
    private int senderId;
    private int receiverId;
    private Date departureTime;
    private int amount;
}
