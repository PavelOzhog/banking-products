package bank.core.entity;

import lombok.Setter;

import java.math.BigDecimal;

@Setter
public abstract class BankProduct {
    protected String currency;
    protected BigDecimal balance;
    protected String name;

    public BankProduct(String currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }

    public abstract void adjunction(BigDecimal amount);



    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }


}
