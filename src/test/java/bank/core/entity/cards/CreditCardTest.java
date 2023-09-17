package bank.core.entity.cards;

import bank.core.entity.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static bank.core.utils.TestConsts.FIRST_TEST_AMOUNT;
import static bank.core.utils.TestConsts.SECOND_TEST_AMOUNT;
import static bank.core.utils.UtilsClass.convertStringToBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
class CreditCardTest extends BaseTest {

    @Tag("unit")
    @Test
    void adjunctionCreditCardTest() {
        eManager.getCreditCard().setBalance(convertStringToBigDecimal(FIRST_TEST_AMOUNT));
        eManager.getCreditCard().adjunction(SECOND_TEST_AMOUNT);
        assertAll(() -> assertEquals(convertStringToBigDecimal(FIRST_TEST_AMOUNT).add(convertStringToBigDecimal(SECOND_TEST_AMOUNT)),
                eManager.getCreditCard().getBalance(), "CreditCard balance havent changed"));
    }

    @Tag("unit")
    @Test
    void writeOffCreditCardTest() {
        eManager.getCreditCard().setBalance(convertStringToBigDecimal(FIRST_TEST_AMOUNT));
        eManager.getCreditCard().writeOff(SECOND_TEST_AMOUNT);
        assertEquals(convertStringToBigDecimal(FIRST_TEST_AMOUNT)
                        .subtract(convertStringToBigDecimal(SECOND_TEST_AMOUNT)),
                eManager.getCreditCard().getBalance(),"CreditCard balance havent changed");

    }
}