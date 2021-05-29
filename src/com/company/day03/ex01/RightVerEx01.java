package com.company.day03.ex01;

import java.util.ArrayList;

public class RightVerEx01 {
    public static void main(String[] args) {

        int count = validateFlag(args);

        BlockingQueue queue = new BlockingQueue();

        Thread worker = new Thread(() -> {
            while (Thread.currentThread().isInterrupted()) {
                Runnable task = null;
                try {
                    task = queue.get();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }
        });
        worker.start();

        for (int i = 0; i < count; i++) {
            queue.put(new EggThread(i));
            queue.put(new HenThread(i));
        }
        worker.interrupt();
    }

    public static class HenThread implements Runnable{

        int henNum;

        public HenThread(int henNum) {
           this.henNum = henNum;
        }

        @Override
        public void run() {
                System.out.println("Hen #" + henNum);
        }
    }

    public static class EggThread implements Runnable{
        int eggNum;

        public EggThread(int eggNum) {
            this.eggNum = eggNum;
        }

        @Override
        public void run() {
                System.out.println("Egg #" + eggNum);
        }
    }

    static class BlockingQueue {
        ArrayList<Runnable> tasks = new ArrayList<>();

        public synchronized Runnable get() throws InterruptedException {
            while (tasks.isEmpty()) {
                    wait();
            }
            Runnable task = tasks.get(0);
            tasks.remove(task);
            return task;
        }

        public synchronized void put(Runnable task) {
            tasks.add(task);
            notify();
        }
    }

    public static int validateFlag(String[] args)
    {
        int count = -1;
        if (args == null)
            return count;
        if (!args[0].startsWith("--count=") ||
                args.length != 1)
            return count;
        try {
            count = Integer.parseInt(args[0].substring(args[0].indexOf("=") + 1));
        }catch (NumberFormatException e){
            return -1;
        }
        return count;
    }
}
