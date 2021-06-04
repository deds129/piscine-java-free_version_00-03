package com.company.day03.ex02;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        String[] testArgs = {"--arraySize=13", "--threadsCount=3"};
        int[] arr;
        int sectionSize;
        FlagValidator flagValidator = new FlagValidator(testArgs);

        if ((flagValidator.getArraySize() < 0  && flagValidator.getArraySize() > 2000000000)
                || flagValidator.getThreadsCount() < 0 || (flagValidator.getArraySize() < flagValidator.getThreadsCount()))
        {
            System.err.println("Incorrect values passed");
            return ;
        }
        arr = new int[flagValidator.getArraySize()];
        fillArray(arr);


        //multithreading part
        Thread[] threads = new Thread[flagValidator.getThreadsCount()];
        sectionSize = flagValidator.getArraySize() / flagValidator.getThreadsCount() + 1;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ArrayCouterThread(arr, sectionSize));
        }

        //hardcode :(
        System.out.println("Sum is: " + simpleSummer(arr));
        for (Thread t: threads) {
            t.start();
            t.join();
        }
        System.out.println("Sum by threads:" + new ArrayCouterThread(arr, sectionSize).getGlobalSum());

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