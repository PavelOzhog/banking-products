package bank.core.utils;

import bank.core.entity.BankProduct;

import java.math.BigDecimal;

public class UtilsClass   {


    public static BigDecimal convertStringToBigDecimal(String amount){
        return new BigDecimal(amount);
    }

    public  static <T extends BankProduct> void adjunctionForBankProd ( T t, String amount) {
        t.setBalance(t.getBalance().add(convertStringToBigDecimal(amount)));
    }

    public  static <T extends BankProduct> void writeOffForBankProd( T t, String amount) {
        if (convertStringToBigDecimal(amount).compareTo(t.getBalance()) <= 0  ) {
              t.setBalance(t.getBalance().subtract(convertStringToBigDecimal(amount)));
        } else {
            System.out.println("Insufficient funds");
        }
    }



}
