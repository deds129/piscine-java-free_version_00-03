package com.company.day01;


public class Program {
    public static void main(String[] args) {
        User user = new User("Andrey", 10000);
        User user1= new User("Sergey", 5000);
        User user2= new User("Misha", 5000);

       TransactionsService transactionsService = new TransactionsService();

       //adding users to service
        transactionsService.addUser(user);
        transactionsService.addUser(user1);
        transactionsService.addUser(user2);



        try {
            //show user balance by id
            System.out.println(transactionsService.getUserBalance(0));
            //show user balance by id balance
            System.out.println(transactionsService.getUserBalanceByIndex(1));

            //perform Transaction
            transactionsService.performTransaction(0,1,2000);
            transactionsService.performTransaction(2,1,100);

            //show user balance by id
            System.out.println(transactionsService.getUserBalance(0));
            //show user balance by id balance
            System.out.println(transactionsService.getUserBalanceByIndex(1));

            System.out.println("User transactions: ");
            Transaction[] trs = transactionsService.getUserTransactions(0);
            for (Transaction tr : trs ) {
                System.out.println(tr.transactionInfo());
            }
            //remove transaction
            transactionsService.removeUserTransactionsById(trs[0].getTransId(),0);

            System.out.println("User transactions after removing: ");
            Transaction[] trs2 = transactionsService.getUserTransactions(0);
            for (Transaction tr : trs2 ) {
                System.out.println(tr.transactionInfo());

            }
            System.out.println("\n");

            System.out.println("Unpair transactions:");
            Transaction[] trs3 = transactionsService.getUnpairedTransactions();
            for (Transaction tr : trs3) {
                System.out.println(tr.transactionInfo());
            }

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalTransactionException e) {
            e.printStackTrace();
        } catch (TransactionNotFoundException e) {
            e.printStackTrace();
        }
    }
}
