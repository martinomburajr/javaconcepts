package utils;

public class Operations {
    public static long sumArray(int [] arr) {
        long base = 0;
        if(arr == null) {
            throw new IllegalStateException("Input array cannot be null");
        }else{
            for (int i = 0; i < arr.length; i++) {
                base = arr[i] + base;
            }
        }
        return base;
    }
}
