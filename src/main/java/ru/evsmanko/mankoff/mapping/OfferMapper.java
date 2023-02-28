package ru.evsmanko.mankoff.mapping;

import org.mapstruct.Mapper;
import ru.evsmanko.mankoff.dto.OfferDTO;
import ru.evsmanko.mankoff.entity.OfferEntity;

@Mapper(componentModel = "spring")
public interface OfferMapper {
    OfferDTO toDTO(OfferEntity offer);
    OfferEntity toEntity(OfferDTO dto);
}
