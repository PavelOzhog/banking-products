import bank.core.entity.Deposit;
import bank.core.entity.cards.CreditCard;
import bank.core.entity.cards.DebitCard;

import java.math.BigDecimal;

import static bank.core.enums.Currency.DOLLAR;
import static bank.core.enums.Currency.RUBLE;
import static bank.core.enums.DepositStatus.ACTIVE;
import static bank.core.enums.DepositStatus.CLOSED;

public class MainDebug {

    public static void main(String[] args) {

        DebitCard db1 = new DebitCard(DOLLAR.getType(), new BigDecimal("48.48889"), "дебетовая карта карта1");
        DebitCard db2 = new DebitCard(RUBLE.getType(), new BigDecimal("48.48888"), "дебетовая карта карта2");
        CreditCard сс = new CreditCard(DOLLAR.getType(), new BigDecimal("48.48888"), "кредитная карта карта1",1.2);

        Deposit dep = new Deposit(DOLLAR.getType(),new BigDecimal("48.48888"),"депозит", ACTIVE);



        db1.writeOff(db2.getBalance());
        System.out.println(db1.getBalance());

        db1.adjunction(db2.getBalance());

        System.out.println(db1.getBalance());

        System.out.println( String.format("%.3f", 1.39));

        db1.adjunction(сс.getBalance());

        dep.setStatus(CLOSED);
        System.out.println(dep.getStatus());

    }

}
