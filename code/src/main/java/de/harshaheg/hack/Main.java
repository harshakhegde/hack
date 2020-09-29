package de.harshaheg.hack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        CelebrityTake1 celebrityTake1 = new CelebrityTake1();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Long> mine = executorService.submit(celebrityTake1);
        Future<Long> theirs = executorService.submit(celebrityTake1);

        System.out.println("Mine:   " + mine.get());
        System.out.println("Theirs: " + theirs.get());

    }

}
