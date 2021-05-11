package com.company.day01;

/*
• Add a transaction
• Remove a transaction by ID (in this case, UUID string identifier is used)
• Transform into array (ex. Transaction[] toArray())
 */

import java.util.UUID;

public interface TransactionsList {

    boolean addTransaction(Transaction transaction);

    boolean removeTransactionById(UUID id);

    TransactionsList[] toArray();

    void showList();
}
