package com.company.day01;

public class TransactionNotFoundException extends Exception {
    public TransactionNotFoundException() {
        super("Transaction not found");
    }

    public TransactionNotFoundException(String message) {
        super(message);
    }
}
