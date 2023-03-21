package pl.x.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private String cardNumber;
    private BigDecimal balance;

    private int withdrawalsInBillingCycle = 0;

    //Constructor
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    //Action methods
    public void assignLimit(BigDecimal amount) {
        if (balance != null) {
            throw new CreditAlreadyAssignedException();
        }
        if (amount.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new CreditBelowLimitException();
        }
        this.balance = amount;
    }

    public void withdraw(BigDecimal amount) {
        if (this.areFundsSufficient(amount)) {
            throw new InsufficientFundsException();
        }
        if (this.withdrawalsInBillingCycle > 9) {
            throw new BillingCycleWithdrawalLimitException();
        }
        this.balance.subtract(amount);
        this.withdrawalsInBillingCycle++;
        // call some external withdraw method

    }

    public void closeBillingCycle() {
        this.withdrawalsInBillingCycle = 0;
    }

    public void reassignLimit(BigDecimal amount) {
        if (this.valueIsUnderLimit(amount)) {
            throw new CreditBelowLimitException();
        }
        this.balance = amount;
    }

    //Getters, Setters and Checkers
    public BigDecimal getCurrentBalance() {
        return this.balance;
    }

    public boolean valueIsUnderLimit(BigDecimal amount) {
        return amount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public boolean areFundsSufficient(BigDecimal amount) {
        return this.balance.compareTo(amount) < 0;
    }
}
