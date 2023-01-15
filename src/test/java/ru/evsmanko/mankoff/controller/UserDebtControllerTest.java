package ru.evsmanko.mankoff.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.evsmanko.mankoff.dto.UserDebtDto;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.service.UserDebtService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserDebtControllerTest {
    @MockBean
    private UserDebtService service;

    @Autowired
    private MockMvc mvc;

    @Test
    void getUserDebt() throws Exception{
        User user = new User();
        user.setId(1);

        when(service.userDebt(user.getId()))
                .thenReturn(new UserDebtDto().setDebt(10000.0));

        mvc.perform(get("/UserDebt/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.debt").value(10000));

        verify(service).userDebt(user.getId());

    }
}
