package miu.lesson.quiz1.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Account {
    private String accountId;
    private String accountNumber;
    private AccountTierType accounTierType;
    private AccountType accountType;

    private LocalDate dateOpened;
    private BigDecimal balance;
    private String customerId;

    public Account(String accountId,
                   String accountNumber,
                   AccountTierType accounTierType,
                   AccountType accountType,
                   LocalDate dateOpened,
                   BigDecimal balance,
                   String customerId) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accounTierType = accounTierType;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
        this.customerId = customerId;
    }

    public AccountTierType getTier() {

        long years = ChronoUnit.YEARS.between(dateOpened, LocalDate.now());

        if (years >= 10 &&
                balance.compareTo(new BigDecimal("100000")) >= 0) {
            return AccountTierType.PLATINUM;
        }

        if (years >= 5 &&
                balance.compareTo(new BigDecimal("50000")) >= 0) {
            return AccountTierType.GOLD;
        }

        return AccountTierType.SILVER;
    }

}
