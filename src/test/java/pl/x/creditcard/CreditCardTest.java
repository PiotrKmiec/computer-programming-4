package pl.x.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    
    @Test
    void itsMyFirstTestRun() {
        assertTrue(true);
    }

    @Test
    void itsMySecondTestRun() {
        boolean value = false;
        assertFalse(value);
    }

    @Test
    void templateTest() {
        //Arrange

        //Act

        //Assert
        assertTrue(true);
    }

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        card.assignLimit(BigDecimal.valueOf(1000));
        //Assert
        assertEqual(BigDecimal.valueOf(1000), card.getCurrentBalance());
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");
        //Act
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1100));
        //Assert // Then
        assertEquals(BigDecimal.valueOf(1000), card1.getCurrentBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getCurrentBalance());
    }

    @Test
    void itDenyLimitsBelow100() {
        CreditCard card1 = new CreditCard("1234-5678");
        assertThrows(
                CreditBelowLimitException.class,
                () -> card1.assignLimit(BigDecimal.valueOf(10)));

        try {
            card1.assignLimit(BigDecimal.valueOf(10));
            fail("Should throw exception");
        } catch (CreditBelowLimitException e) {
            assertTrue(true);
        }

    }
}

}
