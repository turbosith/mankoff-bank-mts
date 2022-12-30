package ru.evsmanko.mankoff.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "app.currency")
public class BalanceOfDebtProperties {
    private double usdToRub;
    private double eurToRub;
    private double rubToRub;
    private String currentCurrency;
}
