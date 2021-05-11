package com.company.day01;


import java.util.LinkedList;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{

    private Node first;
    private Node last;

    private Integer size;

    //container class
    private static class Node {
        Transaction transaction;
        Node next;
        Node previous;

        public Node(Transaction transaction) {
            this.transaction =  transaction;
        }
    }

    public TransactionsLinkedList() {
        this.size = 0;
    }


    @Override
    public boolean addTransaction(Transaction newTransaction) {
        //create container to add new elem
        Node newNode = new Node(newTransaction);
        if (first == null) {
            newNode.next = null;
            first = newNode;
            last = newNode;
            newNode.previous = null;
        }
        else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
        return false;
    }

    @Override
    public boolean removeTransactionById(UUID id) {
        if (size == 0)
            return false;
        else if (size == 1)
        {
            first = null;
            last =null;
            size = 0;
            return true;
        }

            //???
            Node nodeBefore = getNodeById(id);


            if (nodeBefore == null){
                first = first.next;
                size--;
                return  true;
            }
            else if (nodeBefore != null)
            {
                if (last.transaction.transId == id) {
                    nodeBefore.next = null;
                    last = nodeBefore;
                } else {
                  nodeBefore.next = nodeBefore.next.next;
                }
                size--;
            return true;
            }

        return false;
    }

    //add new func
    private Node getNodeById(UUID id) {
        if (size == 0)
            return null;
        if (first.transaction.transId == id)
        {
            return first;
        }
        Node node = first;
        while (node.next != null)
        {
            if (node.next.transaction.transId == id)
                return node;
            node = node.next;
        }
        return null;
    }

    public void showList()
    {
        if (size == 0)
            System.out.println("List is empty!");
        else if (size == 1)
            first.transaction.transactionInfo();
        Node temp = first;
        while (temp != null)
        {
            System.out.println(temp.transaction.transactionInfo());
            temp = temp.next;
        }
    }

    //todo: realise
    @Override
    public TransactionsList[] toArray() {
        return new TransactionsList[0];
    }
}
