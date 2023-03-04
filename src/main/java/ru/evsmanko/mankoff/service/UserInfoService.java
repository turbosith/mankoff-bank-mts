package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.UserInfoDTO;
import ru.evsmanko.mankoff.entity.UserInfoEntity;
import ru.evsmanko.mankoff.mapping.malikov.UserInfoMapper;
import ru.evsmanko.mankoff.repository.malikov.UserInfoJDBCRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserInfoService {

    public final UserInfoJDBCRepository userInfoJDBCRepository;
    public final UserInfoMapper userInfoMapper;

    private List<UserInfoDTO> listToDto(List<UserInfoEntity> users) {
        List<UserInfoDTO> userInfoDTOs = new ArrayList<>();
        for (UserInfoEntity user : users) {
            userInfoDTOs.add(UserInfoMapper.INSTANCE.userInfoEntityToDto(user));
        }
        return userInfoDTOs;
    }

    public List<UserInfoDTO> findAll() {
        var users = userInfoJDBCRepository.findAll();
        return listToDto(users);
    }

    public UserInfoDTO findUserById(Long id) {
        var user = UserInfoMapper.INSTANCE.userInfoEntityToDto(userInfoJDBCRepository.findUserById(id));
        return user;
    }

    public void save(UserInfoEntity userInfoEntity) {
        userInfoJDBCRepository.save(userInfoEntity);
    }
}
