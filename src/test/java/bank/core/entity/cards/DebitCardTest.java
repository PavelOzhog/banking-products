package bank.core.entity.cards;

import bank.core.entity.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static bank.core.utils.TestConsts.FIRST_TEST_AMOUNT;
import static bank.core.utils.TestConsts.SECOND_TEST_AMOUNT;
import static bank.core.utils.UtilsClass.convertStringToBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest extends BaseTest {

    @Tag("unit")
    @Test
    void adjunctionDebitCardTest() {
        eManager.getDebitCard().setBalance(convertStringToBigDecimal(FIRST_TEST_AMOUNT));
        eManager.getDebitCard().adjunction(SECOND_TEST_AMOUNT);
        assertEquals(convertStringToBigDecimal(FIRST_TEST_AMOUNT)
                        .add(convertStringToBigDecimal(SECOND_TEST_AMOUNT)),
                eManager.getDebitCard().getBalance(),"CurrencyDebitCard balance havent changed");


    }

    @Test
    void writeOffDebitCardTest() {
        eManager.getDebitCard().setBalance(convertStringToBigDecimal(FIRST_TEST_AMOUNT));
        eManager.getDebitCard().writeOff(SECOND_TEST_AMOUNT);
        assertEquals(convertStringToBigDecimal(FIRST_TEST_AMOUNT)
                        .subtract(convertStringToBigDecimal(SECOND_TEST_AMOUNT)),
                eManager.getCurrencyDebitCard().getBalance(),"CurrencyDebitCard balance havent changed");
    }
}