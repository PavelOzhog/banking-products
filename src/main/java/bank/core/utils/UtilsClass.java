package bank.core.utils;

import bank.core.entity.BankProduct;

import java.math.BigDecimal;

public class UtilsClass   {

    public  static <T extends BankProduct> void adjunctionForBankProd ( T t, BigDecimal amount) {
        t.setBalance(t.getBalance().add(new BigDecimal(String.valueOf(amount))));
    }

    public  static <T extends BankProduct> void writeOffForBankProd( T t, BigDecimal amount) {
        if (amount.compareTo(t.getBalance()) <= 0  ) {
              t.setBalance(t.getBalance().subtract(amount));
        } else {
            System.out.println("Insufficient funds");
        }
    }



}
