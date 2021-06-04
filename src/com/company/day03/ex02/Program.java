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

        int[] arr;
        int threadCounter;
        FlagValidator flagValidator = new FlagValidator(testArgs);

        if ((flagValidator.getArraySize() < 0  && flagValidator.getArraySize() > 2000000000)
                || flagValidator.getThreadsCount() < 0)
        {
            System.err.println("Incorrect values passed");
            return ;
        }
        threadCounter = Math.min(flagValidator.getArraySize(), flagValidator.getThreadsCount());
        arr = new int[flagValidator.getArraySize()];
        fillArray(arr);







        //multithreading part
        Thread[] threads = new Thread[threadCounter];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ArrayCouterThread());
        }

        for (Thread t: threads) {
            t.start();
        }



        System.out.println("Sum is: " + simpleSummer(arr));
    }

    public static void fillArray(int[] array){
        for (int i = 0; i < array.length ; i++) {
            array[i] = (int) (Math.random() * 2000 - 1000);
        }
    }

    public static long simpleSummer(int[] arr)
    {
        long sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
}



