package homework;


import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
 * Вилки лежат на столе между каждой парой ближайших философов.
 * Каждый философ может либо есть, либо размышлять.
 * Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
 * Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
 * Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
 * Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
 */
public class Main {
    public static void main(String[] args) {
        List<String> philosophersName = new ArrayList<>(Arrays.asList(
                "Аристотель",
                "Иммануил Кант",
                "Платон",
                "Конфуций",
                "Сократ"
        ));



        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++){
            forks[i] = new Fork(i + 1);
        }
        for (int i = 0; i < forks.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % 5];
            if(i == 0){
                philosophers[i] = new Philosopher(philosophersName.get(i), rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(philosophersName.get(i), rightFork, leftFork);
            }
            Thread thread = new Thread(philosophers[i]);
            thread.start();
        }
    }

}
