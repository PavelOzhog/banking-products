package bank.core.entity.cards;

import bank.core.entity.BankProduct;
import bank.core.services.CardService;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

import static bank.core.utils.UtilsClass.*;

@Data
public class CreditCard extends BankProduct implements CardService {

    private double interestRate;
    private BigDecimal debt = convertStringToBigDecimal("0.000");



    public CreditCard() {
    }

    public CreditCard(String currency, BigDecimal balance, String name, double interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    @Override
    public void adjunction(String amount) {
        adjunctionForBankProd(this, amount);

        if (this.getDebt().compareTo(convertStringToBigDecimal("0.000")) >= 0)
        this.setDebt(this.getDebt().subtract(convertStringToBigDecimal(amount)));
    }

    @Override
    public void writeOff(String amount) {
        writeOffForBankProd(this,amount);
        this.setDebt(this.getDebt().add(convertStringToBigDecimal(amount)));
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void checkDebt() {

    }
}
