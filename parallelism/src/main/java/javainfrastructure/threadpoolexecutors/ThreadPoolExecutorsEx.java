package javainfrastructure.threadpoolexecutors;

import utils.NumAns;
import utils.NumberGenerator;
import utils.Operations;

import java.io.IOException;
import java.util.concurrent.*;

public class ThreadPoolExecutorsEx {

    public static void test1() {
        try {
            final NumAns crazyTests2 = NumberGenerator.reader("crazyTests2");
            Callable<Long> test1Callable = (Callable<Long>) () -> {
                long l = Operations.sumArray(crazyTests2.numbers);
                return l;
            };

            Runnable test1Runnable  = () -> {
                long l = Operations.sumArray(crazyTests2.numbers);
                System.out.println("Total: " + l);
            };

            BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(1);
            blockingQueue.add(test1Runnable);

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,10,40000, TimeUnit.MILLISECONDS, blockingQueue);

            threadPoolExecutor.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String [] args) {
        test1();
    }
}
