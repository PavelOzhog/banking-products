package bank.core.entity;

import bank.core.enums.DepositStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static bank.core.enums.DepositStatus.CLOSED;
import static bank.core.utils.UtilsClass.adjunctionForBankProd;


@Setter
public class Deposit extends BankProduct {

    @Getter
    private String status;

    public Deposit(){

    }

    public Deposit(String currency, BigDecimal balance, String name, DepositStatus status) {
        super(currency, balance, name);
        this.status = status.name();
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setStatus(DepositStatus status) {
        this.status = status.name();
    }

    @Override
     public void adjunction(String amount) {
        adjunctionForBankProd(this, amount);
    }

    public void closeDeposit(){
        this.setStatus(CLOSED);
    }

}
