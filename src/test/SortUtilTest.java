package test;
import static seminar1.util.SortUtil.*;

import java.util.Arrays;
import java.util.Random;

public class SortUtilTest {
    public static void main(String[] args) {
        int[] a = generateRandomArray(100);

        System.out.println(test(a));
    }

    public static int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(); // Generates a random integer
        }

        return randomArray;
    }


    public static boolean test(int[] a){
        int[] arr = Arrays.copyOf(a, a.length);;
        int[] cor = Arrays.copyOf(a, a.length);
        int[] tmp;
        Arrays.sort(cor);

        tmp = arr;
        quickSortIterative(tmp);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = Arrays.copyOf(a, a.length);;
        quickSortRecursive(tmp, 0, tmp.length-1);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = Arrays.copyOf(a, a.length);;
        quickSortIterativeRnd(tmp);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = Arrays.copyOf(a, a.length);;
        quickSortRecursiveRnd(tmp, 0, tmp.length-1);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = Arrays.copyOf(a, a.length);;
        quickSortIterative0(tmp);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = Arrays.copyOf(a, a.length);
        quickSortRecursive0(tmp, 0, tmp.length-1);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = Arrays.copyOf(a, a.length);
        insertionSortIterative(tmp);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = Arrays.copyOf(a, a.length);
        insertionSortRecursive(tmp, 0, tmp.length-1);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        return true;
    }
}
