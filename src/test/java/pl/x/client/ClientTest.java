package pl.x.client;

import org.junit.jupiter.api.Test;
import pl.x.creditcard.CreditCard;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    void itAllowsClientCreation() {
        //Act
        Client testClient = new Client("John","Paul","The Second","");
        testClient.setCreditCard("2391-4930-2100");

        //Assert
        assertTrue(testClient.hasCreditCard());
    }
}
