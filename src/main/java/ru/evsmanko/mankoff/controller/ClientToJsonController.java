package ru.evsmanko.mankoff.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.service.ExportUserToJsonService;
import ru.evsmanko.mankoff.mapping.UserMapper;
import ru.evsmanko.mankoff.dto.UserDto;

@RestController
@RequestMapping("ClientToJson")
@AllArgsConstructor
public class ClientToJsonController {
    private ExportUserToJsonService exportUserToJson;
    private UserMapper userMapper;

    @GetMapping
    public UserDto clientToJson(@RequestParam(value = "id", defaultValue = "1") Long id) {
        return userMapper.toDto(exportUserToJson.getUser(id));
    }
}
