package com.company.day03.ex02;

public class ArrayCouterThread implements Runnable {

    private static int threadNum = 0;
    private static int arraySum = 0;

    private final int thisThreadNum;
    private final int[] arr;
    private  int sectionSum = 0;
    private final int startIdx;
    private final int lastIdx;


    public ArrayCouterThread(int[] arr, int sectionSize) {
        thisThreadNum = threadNum;
        this.arr = arr;
        this.startIdx = sectionSize * thisThreadNum;
        this.lastIdx = Math.min(sectionSize * (thisThreadNum + 1), arr.length);
        ++threadNum;
    }

    @Override
    public void run() {
        synchronized (this)
        {
            for (int i = startIdx; i < lastIdx ; i++) {

                sectionSum += arr[i];
            }
            System.out.println("Thread " + thisThreadNum + ": from " + startIdx + " to " + (lastIdx - 1) + " sum is " + sectionSum);
            arraySum += sectionSum;
        }
    }

    public int getGlobalSum() {
        return arraySum;
    }
}
