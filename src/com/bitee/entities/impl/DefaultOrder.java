package com.bitee.entities.impl;

import com.bitee.entities.Order;
import com.bitee.entities.Product;

import java.util.Arrays;

public class DefaultOrder implements Order {
    private static final int AMOUNT_OF_DIGITS_IN_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product[] products;
    private int customerId;

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        return creditCardNumber.toCharArray().length ==AMOUNT_OF_DIGITS_IN_CARD_NUMBER &&
                !creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber)>0;
    }

    @Override
    public void setCreditCardNumber(String userInput) {
    if (creditCardNumber==null){
        return;
    }
    this.creditCardNumber= creditCardNumber;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products=products;
    }

    @Override
    public void setCustomerId(int customerId) {
    this.customerId=customerId;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "DefaultOrder{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", products=" + Arrays.toString(products) +
                ", customerId=" + customerId +
                '}';
    }
}
