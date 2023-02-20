package ru.evsmanko.mankoff.mapping;

import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.dto.TransferDTO;
import ru.evsmanko.mankoff.entity.Transfer;

@Component
public class TransferMapper {
    public TransferDTO toDto(Transfer transfer){
        return new TransferDTO(
                transfer.getId(),
                transfer.getSenderId(),
                transfer.getReceiverId(),
                transfer.getDepartureTime(),
                transfer.getAmount()
        );
    }
}
