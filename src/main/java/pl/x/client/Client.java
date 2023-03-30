package pl.x.client;

import pl.x.creditcard.CreditCard;

import java.util.Arrays;

public class Client {
    public CreditCard creditCard;
    private String firstName;
    private String secondName;
    private String lastName;
    private String prefix;

    public void setPrefix(String prefix) {
        String[] allowedPrefixes = {"Ms.","Mrs.","Dr.","Mr.",""};
        if(Arrays.asList(allowedPrefixes).contains(prefix)){
            this.prefix = prefix;
        }else{
            throw new ProhibitedPrefixException();
        }
    }

    //Constructor
    public Client(String firstName, String secondName, String lastName, String prefix) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.prefix = prefix;
    }

    //Methods
    public boolean hasCreditCard() {
        return (this.creditCard != null);
    }

    //Getters and setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreditCard(CreditCard card) {
        this.creditCard = card;
    }

    public void setCreditCard(String number) {
        this.creditCard = new CreditCard(number);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }
}
