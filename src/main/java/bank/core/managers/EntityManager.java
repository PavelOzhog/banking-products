package bank.core.managers;

import bank.core.entity.Deposit;
import bank.core.entity.cards.CreditCard;
import bank.core.entity.cards.CurrencyDebitCard;
import bank.core.entity.cards.DebitCard;

public class EntityManager {

    private static EntityManager INSTANCE = null;

    private CreditCard creditCard;
    private CurrencyDebitCard currencyDebitCard;
    private DebitCard debitCard;
    private Deposit deposit;


    private EntityManager() {

    }


    public static EntityManager getEntityManager() {
        if (INSTANCE == null) {
            INSTANCE = new EntityManager();
        }
        return INSTANCE;
    }

    public CreditCard getCreditCard() {
        if (creditCard == null) {
            creditCard = new CreditCard();
        }
        return creditCard;
    }

    public CurrencyDebitCard getCurrencyDebitCard() {
        if (currencyDebitCard == null) {
            currencyDebitCard = new CurrencyDebitCard();
        }
        return currencyDebitCard;
    }

    public DebitCard getDebitCard() {
        if (debitCard == null) {
            debitCard = new DebitCard();
        }
        return debitCard;
    }

    public Deposit getDeposit() {
        if (deposit == null) {
            deposit = new Deposit();
        }
        return deposit;
    }


}
