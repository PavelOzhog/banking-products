package bank.core.entity.cards;

import bank.core.entity.BankProduct;
import bank.core.services.CardService;

import java.math.BigDecimal;

import static bank.core.utils.UtilsClass.adjunctionForBankProd;
import static bank.core.utils.UtilsClass.writeOffForBankProd;

public class CurrencyDebitCard extends BankProduct  implements CardService {


    public CurrencyDebitCard(String currency, BigDecimal balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void adjunction(BigDecimal amount) {
        adjunctionForBankProd(this, amount);
    }

    @Override
    public void writeOff(BigDecimal amount) {
        writeOffForBankProd(this, amount);
    }
}
