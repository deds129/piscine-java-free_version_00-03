package com.company.day01;

import javax.jws.soap.SOAPBinding;
import java.util.UUID;

/*
TransactionsService class must contain a field of UserList type for user
interactions and provide the following functionality:
• Adding a user
• Retrieving a user’s balance
• Performing a transfer transaction (user IDs and transfer amount are specified). In
this case, two transactions of DEBIT/CREDIT types are created and added to
recipient and sender. IDs of both transactions must be equal
• Retrieving transfers of a specific user (an ARRAY of transfers is returned). Removing a transaction by ID for a specific user (transaction ID and user ID are
specified)
• Check validity of transactions (returns an ARRAY of unpaired transactions).
In case of an attempt to make a transfer of the amount exceeding user’s residual balance,
IllegalTransactionException runtime exception must be thrown.
An example of use of such classes shall be contained in Program file (creation, initialization,
printing object content on a console).

 */
public class TransactionsService {
    private UsersList usersList;
    private TransactionsList transactionsList;

    public TransactionsService() {
        usersList = new UsersArrayList();
        transactionsList = new TransactionsLinkedList();
    }

    public void addUser(User user){
        usersList.addUser(user);
    }

    public Integer getUserBalance(Integer id) throws UserNotFoundException {
       return usersList.getUserByID(id).getBalance();
    }

    public Integer getUserBalanceByIndex(Integer index) throws UserNotFoundException {
        return usersList.getUserByIndex(index).getBalance();
    }

    public void performTransaction(Integer recipientId, Integer senderId, Integer amount) throws UserNotFoundException, IllegalTransactionException {
        User recipient = usersList.getUserByID(recipientId);
        User sender = usersList.getUserByID(senderId);

        if (recipientId.equals(senderId))
            throw new IllegalTransactionException();

        Transaction transaction1 = new Transaction(recipient,sender,Category.CREDIT,amount);
        usersList.getUserByID(recipientId).addTransaction(transaction1);
        usersList.getUserByID(senderId).addTransaction(transaction1);
        transactionsList.addTransaction(transaction1);

        Transaction transaction2 = new Transaction(sender,recipient, Category.DEBIT, amount, transaction1.getTransId());
        usersList.getUserByID(recipientId).addTransaction(transaction2);
        usersList.getUserByID(senderId).addTransaction(transaction2);
        transactionsList.addTransaction(transaction2);
    }

    public Transaction[] getUserTransactions(Integer id) throws UserNotFoundException {
        return usersList.getUserByID(id).getArrayOfTransactions();
    }

    public void removeUserTransactionsById(UUID trId, Integer id) throws UserNotFoundException, TransactionNotFoundException {
        usersList.getUserByID(id).removeTransaction(trId);
    }

    public Transaction[] getUnpairedTransactions()
    {
        Transaction[] allTransactions = transactionsList.toArray();
        if (allTransactions == null)
            return null;
        Transaction[] retTransactions;
        Integer arrSize = 0;

        for (int i = 0; i < allTransactions.length ; i++) {
            if (!(isDuplicatetransaction(allTransactions, allTransactions[i])))
                arrSize++;
        }

        retTransactions = new Transaction[arrSize];

        for (int i = 0,j = 0; i < allTransactions.length ; i++) {
            if (!(isDuplicatetransaction(allTransactions, allTransactions[i])))
                retTransactions[j++] = allTransactions[i];
        }
        return retTransactions;
    }

    private boolean isDuplicatetransaction(Transaction[] transactions, Transaction transaction)
    {
        if (transactions == null)
            return false;
        for (int i = 0; i < transactions.length ; i++) {
            if (transactions[i].getTransId() == transaction.getTransId())
                return true;
        }
        return false;
    }

    //to test
    //lists out
}
