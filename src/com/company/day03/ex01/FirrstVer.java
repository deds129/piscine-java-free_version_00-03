package com.company.day03.ex01;

public class FirrstVer {

        public static void main(String[] args) {
            String[] arr = {"--count=50"};
            int count = validateFlag(arr);

            if (count < 1){
                System.err.println("Invalid flag!");
                return;
            }
            OutController outController = new OutController();
            Hen hen = new Hen(count, outController);
            Egg egg = new Egg(count, outController);

            Thread eggTread = new Thread(egg);
            Thread henTread = new Thread(hen);


            eggTread.start();
            henTread.start();
    }

    public static class OutController
    {
        private boolean outStatus = false;
        public synchronized void eggOut(int num){
            if (!outStatus)
            {
                try {
                    wait();
                    System.out.println("Egg #" +num);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            outStatus = true;
            notify();
        }

        public synchronized void henOut(int num){
            if (outStatus)
            {
                try {
                    wait();
                    System.out.println("Hen #" + num);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            outStatus = false;
            notify();
        }
    }

    public static class Egg implements Runnable
    {
        private int counter;
        private OutController outController;
        public Egg(int couter, OutController outController) {
            this.counter = couter;
            this.outController = outController;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < counter; i++) {
                try {
                    Thread.sleep((long)(( Math.random() * (500-100) ) + 100));
                    outController.eggOut(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static class Hen implements Runnable
    {
        private int counter;
        private OutController outController;
        public Hen(int couter, OutController outController) {
            this.counter = couter;
            this.outController = outController;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < counter; i++) {
                try {
                    Thread.sleep((long)(( Math.random() * (500-100) ) + 100));
                    outController.henOut(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
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
