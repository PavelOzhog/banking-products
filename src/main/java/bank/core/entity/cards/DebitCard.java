package bank.core.entity.cards;

import bank.core.entity.BankProduct;
import bank.core.services.CardService;
import lombok.Setter;

import java.math.BigDecimal;

import static bank.core.utils.UtilsClass.adjunctionForBankProd;
import static bank.core.utils.UtilsClass.writeOffForBankProd;


@Setter
public class DebitCard extends BankProduct implements CardService {


    public DebitCard(String currency, BigDecimal balance, String name) {
        super(currency, balance, name);
    }

    public DebitCard(){
    }

    @Override
    public void adjunction(String amount) {
        adjunctionForBankProd(this, amount);
    }

    @Override
    public void writeOff(String amount) {
        writeOffForBankProd(this, amount);
    }
}
