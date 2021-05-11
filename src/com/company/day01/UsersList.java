package com.company.day01;

/*
. To ensure more flexibility, let us define UsersList interface that
describes the following behavior:
• Add a user
• Retrieve a user by ID
• Retrieve a user by index
• Retrieve the number of users
 */



public interface UsersList {

    //Add a user
    boolean addUser(User user);

    //Retrieve a user by ID
    User getUserByID(Integer id) throws UserNotFoundException;

    //Retrieve a user by index
    User getUserByIndex(Integer index);

    //Retrieve the number of users
    Integer getNumberOfUsers();
}
