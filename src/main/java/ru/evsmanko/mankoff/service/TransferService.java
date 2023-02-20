package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.TransferDTO;
import ru.evsmanko.mankoff.entity.Transfer;
import ru.evsmanko.mankoff.mapping.TransferMapper;
import ru.evsmanko.mankoff.repository.TransferRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferService {
    private final TransferRepository transferRepository;
    private final TransferMapper transferMapper;

    private List<TransferDTO> convertListToDto(List<Transfer> transfers) {
        List<TransferDTO> transfersDto = new ArrayList<>();
        for (Transfer transfer: transfers){
            transfersDto.add(transferMapper.toDto(transfer));
        }
        return transfersDto;
    }

    public List<TransferDTO> findAll() {
        var transfers = transferRepository.findAll();
        return convertListToDto(transfers);
    }

    public List<TransferDTO> findBySenderId(Long id) {
        var transfers = transferRepository.findBySenderId(id);
        return convertListToDto(transfers);
    }

    public TransferDTO save(Transfer transfer) {
        transferRepository.save(transfer);
        return transferMapper.toDto(transfer);
    }
}
