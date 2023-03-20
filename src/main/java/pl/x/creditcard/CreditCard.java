package pl.x.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private String cardNumber;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new CreditBelowLimitException();
        }
        this.balance = amount;
    }

    public BigDecimal getCurrentBalance() {
        return this.balance;
    }
}
