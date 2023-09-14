package bank.core.entity.cards;

import bank.core.entity.BankProduct;
import bank.core.services.CardService;
import lombok.Setter;

import java.math.BigDecimal;

import static bank.core.utils.UtilsClass.adjunctionForBankProd;
import static bank.core.utils.UtilsClass.writeOffForBankProd;

@Setter
public class CreditCard extends BankProduct implements CardService {

    private double interestRate;
    private BigDecimal debt;

    public CreditCard(String currency, BigDecimal balance, String name, double interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    @Override
    public void adjunction(BigDecimal amount) {
        adjunctionForBankProd(this, amount);
    }

    @Override
    public void writeOff(BigDecimal amount) {
        writeOffForBankProd(this,amount);
        debt = debt.add(amount);
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void checkDebt() {
// Check and display debt information
    }
}
