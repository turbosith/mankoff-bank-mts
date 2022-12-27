package ru.evsmanko.mankoff.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.service.ExportUserToJsonService;

@RestController
@AllArgsConstructor
public class ClientToJsonController {
    private final ExportUserToJsonService exportUserToJson;

    @GetMapping("ClientToJson")
    public User clientToJson(@RequestParam(value = "id", defaultValue = "1") String id) {
        return exportUserToJson.getUser(id);
    }
}
