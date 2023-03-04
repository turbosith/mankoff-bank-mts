package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.OfferDTO;
import ru.evsmanko.mankoff.entity.OfferEntity;
import ru.evsmanko.mankoff.mapping.OfferMapper;
import ru.evsmanko.mankoff.repository.OfferRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    public List<OfferDTO> listToDTO(List<OfferEntity> offerEntities) {
        List<OfferDTO> offerDTOS = new ArrayList<>();
        for (OfferEntity offerEntity : offerEntities) {
            offerDTOS.add(offerMapper.toDTO(offerEntity));
        }
        return offerDTOS;
    }

    public List<OfferDTO> findAll() {
        var offerEntities = offerRepository.findAll();
        return listToDTO((List<OfferEntity>) offerEntities);
    }

    public List<OfferDTO> findAllByUserId(Long id) {
        var offerEntities = offerRepository.findByUser(id);
        return listToDTO(offerEntities);
    }

    public OfferDTO save(OfferEntity offer) {
        offerRepository.save(offer);
        return offerMapper.toDTO(offer);
    }
}
