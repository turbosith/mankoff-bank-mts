package ru.evsmanko.mankoff.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.evsmanko.mankoff.dto.AverageIncomeDTO;
import ru.evsmanko.mankoff.service.AverageIncomeService;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AverageIncomeRestController.class)
@AutoConfigureMockMvc
class AverageIncomeRestControllerTest {
    private final long USER_ID = 2;
    @MockBean
    private AverageIncomeService service;

    @Autowired
    private MockMvc mvc;
    @Test
    void getAverageIncome() throws Exception {
        when(service.averageIncome(USER_ID)).thenReturn(new AverageIncomeDTO().setAverageIncome(20.0));
        mvc.perform(get("/averageIncome/2")).andExpect(status().isOk()).andExpect(jsonPath("$.averageIncome", equalTo(20.0)));
            verify(service).averageIncome(USER_ID);

    }
}