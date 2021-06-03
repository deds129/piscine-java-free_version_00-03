package com.company.day03.ex02;
/*
Let’s assume there is an array of integer values. Your goal is to calculate the sum of array
elements using several "summing" threads. Each thread computes a certain section inside
the array. The number of elements in each section is constant, except for the last one (its
size can differ upward or downward).
The array shall be randomly generated each time. Array length and the number of threads
are passed as command-line arguments.
To make sure the program operates correctly, we should start by calculating the sum of
array elements using a standard method.
Maximum number of array elements is 2,000,000. Maximum number of threads is no
greater than current number of array elements. Maximum modulo value of each array
element is 1,000. All data is guaranteed to be valid.
 */
public class Program {
    public static void main(String[] args) {
        String[] testArgs = {"--arraySize=13", "--threadsCount=3"};
        FlagValidator flagValidator = new FlagValidator(testArgs);
        System.out.println(flagValidator.getArraySize() +" "+ flagValidator.getThreadsCount());

    }
}

