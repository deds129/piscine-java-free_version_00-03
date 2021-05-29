package com.company.day03.ex00;

public class Program {
    public static void main(String[] args) {
       // String[] arr = {"--count=50"};
        int count = validateFlag(args);

        if (count < 1){
            System.err.println("Invalid flag!");
            return;
        }

        Thread henThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <count ; i++) {
                    try {
                        Thread.sleep((long)(( Math.random() * (500-100) ) + 100));
                        System.out.println("Egg #" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread humanThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <count ; i++) {
                    try {
                        Thread.sleep((long)(( Math.random() * (500-100) ) + 100));
                        System.out.println("Hen #" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }
        });
        humanThread.start();
        henThread.start();

        for (int i = 0; i < count ; i++) {
            try {
                Thread.sleep((long)(( Math.random() * (500-100) ) + 100));
                System.out.println("Human #" +i);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
