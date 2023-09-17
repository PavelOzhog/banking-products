package bank.core.entity;

import lombok.Setter;

import java.math.BigDecimal;

@Setter
public abstract class BankProduct {
    protected String currency;
    protected BigDecimal balance;
    protected String name;

    protected BankProduct(String currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }

    protected BankProduct() {
    }

    public abstract void adjunction(String amount);

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }


}
