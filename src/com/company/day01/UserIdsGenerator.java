package com.company.day01;

//create singleton pattern
//Признаки применения паттерна: Одиночку можно определить по статическому создающему методу, который возвращает один и тот же объект.
public class UserIdsGenerator {

    public static Integer globalId = 0;
    //In order to store the state of the class, we need a global variable
    private static UserIdsGenerator instance;

    //In order that it was impossible to create an instance of a class (object) using a constructor
    private UserIdsGenerator() {}

    /**
     *
     * @param
     * @return returning and creating the same object
     */
    public static synchronized UserIdsGenerator getInstance() //synchronized for multreading
    {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public Integer generateId()
    {
        return globalId++;
    }
}
