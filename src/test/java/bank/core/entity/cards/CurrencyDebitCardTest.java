package bank.core.entity.cards;

import bank.core.entity.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static bank.core.utils.TestConsts.FIRST_TEST_AMOUNT;
import static bank.core.utils.TestConsts.SECOND_TEST_AMOUNT;
import static bank.core.utils.UtilsClass.convertStringToBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyDebitCardTest extends BaseTest {

    @Tag("unit")
    @Test
    void adjunctionCurrencyDebitCardTest() {
        eManager.getCurrencyDebitCard().setBalance(convertStringToBigDecimal(FIRST_TEST_AMOUNT));
        eManager.getCurrencyDebitCard().adjunction(SECOND_TEST_AMOUNT);
        assertEquals(convertStringToBigDecimal(FIRST_TEST_AMOUNT)
                        .add(convertStringToBigDecimal(SECOND_TEST_AMOUNT)),
                eManager.getCurrencyDebitCard().getBalance(),"CurrencyDebitCard balance havent changed");
    }

    @Tag("unit")
    @Test
    void writeOffCurrencyDebitCardTest() {
        eManager.getCurrencyDebitCard().setBalance(convertStringToBigDecimal(FIRST_TEST_AMOUNT));
        eManager.getCurrencyDebitCard().writeOff(SECOND_TEST_AMOUNT);
        assertEquals(convertStringToBigDecimal(FIRST_TEST_AMOUNT)
                        .subtract(convertStringToBigDecimal(SECOND_TEST_AMOUNT)),
                eManager.getCurrencyDebitCard().getBalance(),"CurrencyDebitCard balance havent changed");


    }
}