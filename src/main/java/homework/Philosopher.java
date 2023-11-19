package homework;

import java.util.concurrent.CountDownLatch;

public class Philosopher implements Runnable{

    private final String name;
    private int eating = 3;
    private final Fork rightFork;
    private final Fork leftFork;

    public Philosopher(String name, Fork rightFork, Fork leftFork) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }


    @Override
    public void run() {
        int count = 0;
        while (eating > 0){
            try {
                System.out.println("Философ " + name + " размышляет.");
                Thread.sleep(5000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            synchronized (leftFork){
                synchronized (rightFork){
                    try {
                        count++;
                        System.out.println("Философ " + name + ", взял вилки и кушает( Кол-во приемов еды: " + count + ").");
                        Thread.sleep(5000);
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    eating--;
                    try {
                        Thread.sleep(1000);
                        System.out.println("Философ " + name + " положил вилки на стол");
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        System.out.println("Философ " + name + " за сегодня поел три раза и больше не хочет.");
    }
}
