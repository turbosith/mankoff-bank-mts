package ru.evsmanko.mankoff.mapping.malikov;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.evsmanko.mankoff.dto.UserInfoDTO;
import ru.evsmanko.mankoff.entity.UserInfoEntity;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    UserInfoDTO userInfoEntityToDto(UserInfoEntity userInfoEntity);


}
