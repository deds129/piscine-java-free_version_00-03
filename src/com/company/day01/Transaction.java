package com.company.day01;

import java.util.UUID;

enum Category
{
    DEBIT, //outcome
    CREDIT //income
}

public class Transaction {

    UUID transId;

    User recipient;
    User sender;
    Category category;
    Integer amount;

    public Transaction(User recipient, User sender, Category category, Integer amount) {
        this.transId = UUID.randomUUID();
        this.recipient = recipient;

        this.sender = sender;

        this.category = category;

        if (amount > 0)
            this.amount = amount;
        else
            amount = 0;

        if (category == Category.CREDIT) {
            if (sender.outgoingBalance(amount))
                recipient.incomeBalance(amount);
            else
                System.out.println("Cannot make this transaction!");
        }

        if (category == Category.DEBIT) {
            if (recipient.outgoingBalance(amount))
                sender.incomeBalance(amount);
            else
                System.out.println("Cannot make this transaction!");
        }
    }

    public UUID getTransId() {
        return transId;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAmount() {
        return amount;
    }

    public String transactionInfo()
    {
        return ("Tranaction ID: " + transId +
                ", recipient: " + recipient.getUserId() + " " + recipient.getName() +
                ", sender: " + sender.getUserId() + " " + sender.getName() +
                ", category: " + category +
                ", amount: " + amount + "\n");
    }
}
