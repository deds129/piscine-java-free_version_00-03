package com.company.day01;

public class IllegalTransactionException extends Exception {
    public IllegalTransactionException() {
        super("Illegal transaction");
    }

    public IllegalTransactionException(String message) {
        super(message);
    }
}
