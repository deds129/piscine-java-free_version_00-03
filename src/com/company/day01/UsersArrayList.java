package com.company.day01;

public class UsersArrayList implements UsersList {

    private final Integer DEFAULT_CAPACITY = 10;

    private User[] userArrayList;
    private Integer size;
    private Integer capacity;

    public UsersArrayList() {
         userArrayList = new User[DEFAULT_CAPACITY];
          size = 0;
          capacity = userArrayList.length;
    }

    public UsersArrayList(Integer listSize) {
        userArrayList = new User[listSize];
         size = 0;
         capacity = userArrayList.length;
    }


    @Override
    public boolean addUser(User user) {
        if (size.equals(capacity))
            increaseSize();
        userArrayList[size++] = user;
        return true;
    }

    @Override
    public User getUserByID(Integer id) throws UserNotFoundException {
        for (User user : userArrayList) {
            if (id.equals(user.getUserId()))
                return user;
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(Integer index)  {
            return userArrayList[index];
    }

    @Override
    public Integer getNumberOfUsers() {
        return size;
    }
    private void increaseSize() {
        capacity *= 2;
        User[] temp = new User[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = userArrayList[i];
        }
        userArrayList = temp;
    }

//replace w/o using Arrays

//    private void increaseSize() {
//        userArrayList = Arrays.copyOf(userArrayList, userArrayList.length >> 2);
//        capacity = userArrayList.length;
//    }
}
