package bank.core.entity;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static bank.core.enums.DepositStatus.*;
import static bank.core.utils.TestConsts.FIRST_TEST_AMOUNT;
import static bank.core.utils.TestConsts.SECOND_TEST_AMOUNT;
import static bank.core.utils.UtilsClass.convertStringToBigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositTest extends BaseTest {


    @Tag("unit")
    @Test
    void getBalanceTest() {
        eManager.getDeposit().setBalance(new BigDecimal(FIRST_TEST_AMOUNT));
        assertEquals(0, eManager.getDeposit().getBalance().compareTo(convertStringToBigDecimal(SECOND_TEST_AMOUNT)), "Balance havent changed");
    }


    @Tag("unit")
    @Test
    void setStatusTest() {
        eManager.getDeposit().setStatus(ACTIVE);
        assertEquals(ACTIVE.name(), eManager.getDeposit().getStatus());
        eManager.getDeposit().setStatus(PROCESSING);
        assertEquals(PROCESSING.name(), eManager.getDeposit().getStatus());
        eManager.getDeposit().setStatus(CLOSED);
        assertEquals(CLOSED.name(), eManager.getDeposit().getStatus());
    }

    @Tag("unit")
    @Test
    void adjunctionTest() {
        eManager.getDeposit().setBalance(convertStringToBigDecimal(FIRST_TEST_AMOUNT));
        eManager.getDeposit().adjunction(SECOND_TEST_AMOUNT);
        assertEquals(convertStringToBigDecimal(FIRST_TEST_AMOUNT)
                        .add(convertStringToBigDecimal(SECOND_TEST_AMOUNT)),
                eManager.getDeposit().getBalance(), "Deposit havent changed");
    }

    @Tag("unit")
    @Test
    void closeDepositTest() {
        eManager.getDeposit().closeDeposit();
        assertEquals(CLOSED.name(), eManager.getDeposit().getStatus(), "Deposit has status" + eManager.getDeposit().getStatus());

    }
}