package javainfrastructure.callable;

import java.util.Random;
import java.util.concurrent.*;

public class IntegerCallable {
    public static int[] generateRandomArray(int length, int constituentsMax) {
        int [] randomArr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomArr[i] = random.nextInt(constituentsMax);
        }
        return randomArr;
    }

    private Callable<Integer> callable = new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            long startTime =  System.nanoTime();
            int[] randomArray = generateRandomArray(50000000, 30);
            System.out.println("Callable Running on: " + Thread.currentThread().getName());
            int val = 0;
            for (int i = 0; i < randomArray.length; i++) {
                val += randomArray[i];
            }
            long elapsed = System.nanoTime();
            System.out.println("Time " + (elapsed - startTime)/1000 + "microns");
            return val;
        }
    };

    public static void main(String args[]) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        IntegerCallable integerCallable = new IntegerCallable();
        try {
            Callable<Integer> callable = integerCallable.callable;

            Future<Integer> future = executorService.submit(callable);
            Integer integer = future.get();

            System.out.println("Final value: " + integer +"\nThread: " + Thread.currentThread().getName() );

        } catch (Exception e) {
            executorService.shutdown();
            System.err.println("EXECUTOR SHUTDOWN!");
            e.printStackTrace();
        }
    }
}
