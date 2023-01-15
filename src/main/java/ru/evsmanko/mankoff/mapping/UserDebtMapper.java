package ru.evsmanko.mankoff.mapping;

import ru.evsmanko.mankoff.dto.UserDebtDto;

public class UserDebtMapper {
    public UserDebtDto mapUserDebtDto(double debt){
        return new UserDebtDto().setDebt(debt);
    }
}
