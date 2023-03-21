package pl.x.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");

        //Act
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1100));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getCurrentBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getCurrentBalance());

    }

    @Test
    void itDenyLimitsBelow100() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");

        //Act & Assert
        assertThrows(
                CreditBelowLimitException.class,
                () -> card1.assignLimit(BigDecimal.valueOf(10))
        );
    }

    @Test
    void itDenyWithdrawalOverLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");

        //Act
        card1.assignLimit(BigDecimal.valueOf(100));

        //Assert
        assertThrows(InsufficientFundsException.class, () -> card1.withdraw(BigDecimal.valueOf(101)));
    }

    @Test
    void itDenyWithdrawalIfBillingCycleLimitOver10() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");

        //Act
        card1.assignLimit(BigDecimal.valueOf(100));
        for(int i = 0; i < 10; i++){
            card1.withdraw(BigDecimal.valueOf(1));
        }

        //Assert
        assertThrows(BillingCycleWithdrawalLimitException.class, () -> card1.withdraw(BigDecimal.valueOf(1)));
    }

    @Test
    void itAllowsReassignment() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        card1.assignLimit(BigDecimal.valueOf(100));

        //Act
        card1.reassignLimit(BigDecimal.valueOf(101));

        //Assert
        assertEquals(BigDecimal.valueOf(101), card1.getCurrentBalance());
        assertThrows(CreditBelowLimitException.class, () -> card1.reassignLimit(BigDecimal.valueOf(99)));
    }
}
