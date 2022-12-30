package ru.evsmanko.mankoff.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.evsmanko.mankoff.dto.BalanceOfDebtDTO;
import ru.evsmanko.mankoff.service.BalanceOfDebtService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BalanceOfDebtController.class)
@AutoConfigureMockMvc
class BalanceOfDebtControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BalanceOfDebtService service;

    @Test
    void getBalanceOfDebt() throws Exception {
        when(service.getBalance()).thenReturn(new BalanceOfDebtDTO().setAmount(5000.0));
        mockMvc.perform(get("/getBalanceOfDebt")).andExpect(status().isOk()).andExpect(jsonPath("$.amount", equalTo(5000.0)));
        verify(service).getBalance();
    }
}