package rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;

public class SimpleRxJava {
    public static void main(String [] args) {


        int [] arr = new int[]{2,3,5,6,7,8};
        int[] ints = Arrays.copyOfRange(arr, 0, 2);
        int[] ints1 = Arrays.copyOfRange(arr, (2 + 1), arr.length);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }


//        Observable.just(heavyComputation())
//                .subscribeOn(Schedulers.computation())
//                .observeOn(Schedulers.computation())
//                .subscribe((Double v) -> {
//                    System.out.println("Thread: onNext" + Thread.currentThread().getName());
//                    System.out.printf("Answer is");
//                    System.out.println(v);
//                },
//                    e -> {System.out.println("Thread: onError" + Thread.currentThread().getName());},
//                    () -> {System.out.println("Thread: onComplete" + Thread.currentThread().getName());},
//                    disposable -> {System.out.println("Thread: onSubscribe" + Thread.currentThread().getName());});
    }

    public static double heavyComputation() {
        double pow = Math.pow(15.23, 100);
        pow = Math.asin(pow);
        pow = Math.pow(pow,33);
        pow = Math.atan(pow);
        return pow;
    }
}
