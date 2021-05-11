package com.company.day01;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.jws.soap.SOAPBinding;

public class Program {
    public static void main(String[] args) {

        User user = new User("Mike",2000);
        User user1 = new User("Sam", 2000);
        User user2 = new User("Jack", 3000);
        UsersList usersList = new UsersArrayList();

        System.out.println("Add users");
        usersList.addUser(user1);
        usersList.addUser(user);
        usersList.addUser(user2);

        Transaction transaction = new Transaction(usersList.getUserByIndex(0),
                usersList.getUserByIndex(1),Category.DEBIT,
                500);


        Transaction transaction2 = new Transaction(usersList.getUserByIndex(2),
                usersList.getUserByIndex(1),Category.CREDIT,
                1000);

        TransactionsList transactionsList = new TransactionsLinkedList();
        transactionsList.addTransaction(transaction);
        transactionsList.addTransaction(transaction2);
        transactionsList.showList();


    }
}
