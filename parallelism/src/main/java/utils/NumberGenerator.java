package utils;

import java.io.*;
import java.util.Random;

public class NumberGenerator {
    private static String OUTPUT_FILE_PATH = "C:\\Users\\User\\Desktop\\Other\\scar\\android\\javaconcepts\\parallelism\\src\\main\\resources";


    public static File intGenerator(String name, int length, int bounds) throws IOException {
        String finalPath = (OUTPUT_FILE_PATH +"\\" + name);
        File file = new File(finalPath);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(finalPath));
        Random random = new Random();
        long total = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(bounds);
            if( i == length - 1) {
                bufferedWriter.write(String.valueOf(randomInt));
            }else{
                bufferedWriter.write(randomInt + ",");
            }
            total = total + randomInt;
        }
        long endTime = System.nanoTime();
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();
        long elapsed = ((endTime-startTime)/1000);
        bufferedWriter.write(String.valueOf(elapsed));

        bufferedWriter.close();
        return file;
    }

    public static NumAns reader(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line = bufferedReader.readLine();
        long totalSum = 0;
        long elapsed = 0;
        int count = 0;
        String[] arr = null;
        while(line != null && count < 3) {
            if(count == 0) {
                arr = line.split(",");
            }else if (count == 1) {
                totalSum = Long.valueOf(line);
            }else if(count == 2) {
                elapsed = Long.valueOf(line);
            }
            line = bufferedReader.readLine();
            count++;
        }
        int [] ar2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ar2[i] = Integer.valueOf(arr[i]);
        }
        return new NumAns(ar2,totalSum,elapsed);
    }

    public static void main(String [] args){
        FileLengthBound fileLengthBound1 = new FileLengthBound(300,20);
        FileLengthBound fileLengthBound2 = new FileLengthBound(5325,10000);
        FileLengthBound fileLengthBound3 = new FileLengthBound(46736,434);
        FileLengthBound fileLengthBound4 = new FileLengthBound(1000000,7);

        FileLengthBound[] fileLengthBoundArr = new FileLengthBound[]{fileLengthBound1,fileLengthBound2,fileLengthBound3,fileLengthBound4};

        try {
            createTests("crazyTests", fileLengthBoundArr);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            intGenerator("test1",1000000,9);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            NumAns reader = reader(OUTPUT_FILE_PATH + "\\" + "test1");
//            String s = "";
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void createTests(String baseNames, FileLengthBound[] fileLengthBound) throws IOException {
        for (int i = 0; i < fileLengthBound.length; i++) {
            intGenerator(baseNames + "" + i, fileLengthBound[i].length, fileLengthBound[i].bound);
        }
    }
}
