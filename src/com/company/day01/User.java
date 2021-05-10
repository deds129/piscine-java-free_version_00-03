package com.company.day01;

public class User {

  //  private static Integer globalId = 1;


    private Integer        userId;
    private String         name;
    private Integer        balance;

    public User(String name, Integer balance) {
        this.balance = balance < 0 ? 0: balance;
        this.name = name;
        this.userId = UserIdsGenerator.getInstance().generateId();
    }

    public Integer getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setBalance(Integer balance) {
        if (balance >= 0)
            this.balance = balance;
        else
            balance = 0;
    }

    public void incomeBalance(Integer sum)
    {
        this.balance += sum;
    }

    public boolean outgoingBalance(Integer sum)
    {
        if (sum <= this.balance) {
            this.balance -= sum;
            return  true;
        }
        else
            return false;
    }



    public void showUserInfo()
    {
        System.out.println("ID: " + userId +
                            ", Name: " + name +
                            ", balance: " + balance);
    }

}