package seminar3.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task1a();
        //task1b();
        //task1c();
        //task1d();
    }

    public static void task1a(){
        Integer[] tmp = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};

        System.out.println("----- Task1.a -----");

        BinaryHeap bh1 = new BinaryHeap(tmp.length);
        for (Integer x : tmp) {
            bh1.insert(x);
        }

        System.out.println(Arrays.toString(bh1.getArray()));
    }

    public static void task1b(){
        Integer[] tmp = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};

        System.out.println("----- Task1.b -----");

        BinaryHeap bh2 = new BinaryHeap(tmp);

        System.out.println(Arrays.toString(bh2.getArray()));
    }

    public static void task1c(){
        Integer[] tmp = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};

        System.out.println("----- Task1.c -----");
        System.out.println("First tree:");

        BinaryHeap bh1 = new BinaryHeap(tmp.length);
        for (Integer x : tmp) {
            bh1.insert(x);
        }
        bh1.printPreOrder();
        bh1.printInOrder();
        bh1.printPostOrder();
        bh1.printLevelOrder();

        System.out.println("Second tree:");

        BinaryHeap bh2 = new BinaryHeap(tmp);

        bh2.printPreOrder();
        bh2.printInOrder();
        bh2.printPostOrder();
        bh2.printLevelOrder();
    }

    public static void task1d(){
        System.out.println("----- Task1.d -----");

        String[] names = {"Algo1", "Algo2"};
        int times = 10;
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        double[][] durations = new double[2][sizes.length];

        Integer[] arr = readIntegers("src/seminar1/files/random_numbers.txt", 1000000);
        Integer[] tmp;

        for (int i = 0; i < durations.length; i++) {
            System.out.println("i: " + i);
            for (int j = 0; j < sizes.length; j++) {
                System.out.println("j: " + j);
                for (int k = 0; k < times; k++) {
                    System.out.println("k: " + k);
                    tmp = cropArray(arr, sizes[j]);

                    long startTime = System.nanoTime();
                    runTask1Algo(i, tmp);
                    long endTime = System.nanoTime();
                    double duration = (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

                    durations[i][j] += duration;

                }
            }
        }

        for (int i = 0; i < durations.length; i++) {
            for (int j = 0; j < sizes.length; j++) {
                durations[i][j] /= times;
            }
        }

        //print result
        System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", "Algorithm used",
                "100", "1_000", "10_000", "100_000", "1_000_000");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < durations.length; i++) {
            System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", names[i],
                    durations[i][0], durations[i][1], durations[i][2], durations[i][3], durations[i][4]);
        }


    }

    private static Integer[] cropArray(Integer[] originalArray, int newSize){
        if (newSize >= originalArray.length){
            return originalArray;
        }
        Integer[] resizedArray = new Integer[newSize];

        System.arraycopy(originalArray, 0, resizedArray, 0, newSize);

        return resizedArray;
    }

    private static void runTask1Algo(int mode, Integer[] arr){
        if (mode == 0){
            BinaryHeap bh = new BinaryHeap(arr.length);
            for (Integer x : arr) {
                bh.insert(x);
            }
        }
        else if (mode == 1){
            BinaryHeap bh = new BinaryHeap(arr);
        }
    }

    private static Integer[] readIntegers(String path, int size){
        if (!Files.exists(Paths.get(path))){
            System.out.println("File not found");
            return null;
        }

        Integer[] arr = new Integer[size];

        try (Scanner reader = new Scanner(new File(path))){
            for (int i = 0; i < size; i++) {
                if (!reader.hasNextInt()){
                    System.out.println("File not long enough for request");
                    return null;
                }
                arr[i] = reader.nextInt();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return arr;
    }

    public static void test(){
        BinaryHeap binaryHeap1 = new BinaryHeap(11);
        binaryHeap1.insert(13);
        binaryHeap1.insert(21);
        binaryHeap1.insert(16);
        binaryHeap1.insert(24);
        binaryHeap1.insert(31);
        binaryHeap1.insert(19);
        binaryHeap1.insert(68);
        binaryHeap1.insert(65);
        binaryHeap1.insert(26);
        binaryHeap1.insert(32);

        binaryHeap1.insert(14);

        Integer[] x = {13, 21, 16, 24, 31, 19, 68, 65, 26, 32, 14};

        BinaryHeap binaryHeap2 = new BinaryHeap(x);


        System.out.println(Arrays.toString(binaryHeap1.getArray()));
        System.out.println(Arrays.toString(binaryHeap2.getArray()));
    }
}
