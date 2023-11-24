package seminar1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static seminar1.util.SortUtil.*;

public class Main {
    public static void main(String[] args) {

        String path = "src/seminar1/files/random_numbers.txt";



        automatedAnalysis(path);


    }


    private static void automatedAnalysis(String path){
        /*
        10 iterations min
        1000000
        100000
        10000
        1000
        100
        */

        String[] names = {"insertionSortRecursive", "insertionSortIterative",
        "quickSortRecursive", "quickSortIterative",
        "quickSortRecursiveRnd", "quickSortIterativeRnd",
        "quickSortRecursive0", "quickSortIterative0"};

        int times = 10; // times to run algo
        double[][] duration = new double[8][5]; // duration of algo in ms

        int[] sizes = {1_000_000, 100_000, 10_000, 1_000, 100};

        int[] fileContent = readIntFromFile(path, 1_000_000);
        int[] arr;

        for (int i = 0; i < 8; i++) {
            arr = fileContent;
            for (int j = 0; j < sizes.length; j++) {
                arr = cropArray(arr, sizes[j]);

                duration[i][j] = analyze(arr, times, i);
            }
        }

        //print result
        System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", "Algorithm used",
                "1 000 000", "100 000", "10 000", "1 000", "100");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < duration.length; i++) {
            System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", names[i],
                    duration[i][0], duration[i][1], duration[i][2], duration[i][3], duration[i][4]);
        }

    }

    /**
     *
     * @param arr array to be sorted
     * @param times times that the sorting method is done
     * @param mode 0 = insertionSortRecursive, 1 = insertionSortIterative,<br>
     *             2 = quickSortRecursive, 3 = quickSortIterative,<br>
     *             4 = quickSortRecursiveRnd, 5 = quickSortIterativeRnd,<br>
     *             6 = quickSortRecursive0, 7 = quickSortIterative0.<br>
     * @return average time it took to run the sort method (in milliseconds)
     */
    public static double analyze(int[] arr, int times, int mode){
        double[] durations = new double[times];
        boolean overflow;

        for (int i = 0; i < times; i++) {
            overflow = false;
            arr = shuffleArray(arr);

            long startTime = System.nanoTime();

            try {
                runSort(arr, mode);
            } catch (StackOverflowError e){
                overflow = true;
            }

            long endTime = System.nanoTime();

            if (overflow){
                durations[i] = -1;
            }
            else {
                double duration = (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

                durations[i] = duration;
            }
        }

        return calculateAverage(durations);
    }

    public static double calculateAverage(double[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null");
            return -1;
        }

        double sum = 0;
        for (double value : arr) {
            sum += value;
        }

        return (double) sum / arr.length;
    }

    /**
     *
     *
     * @param arr array to be sorted
     * @param mode 0 = insertionSortRecursive, 1 = insertionSortIterative,<br>
     *             2 = quickSortRecursive, 3 = quickSortIterative,<br>
     *             4 = quickSortRecursiveRnd, 5 = quickSortIterativeRnd,<br>
     *             6 = quickSortRecursive0, 7 = quickSortIterative0.<br>
     */
    public static void runSort(int[] arr, int mode){
        switch (mode){
            case 0:
                insertionSortRecursive(arr, 0, arr.length-1);
                break;
            case 1:
                insertionSortIterative(arr);
                break;
            case 2:
                quickSortRecursive(arr, 0, arr.length-1);
                break;
            case 3:
                quickSortIterative(arr);
                break;
            case 4:
                quickSortRecursiveRnd(arr, 0, arr.length-1);
                break;
            case 5:
                quickSortIterativeRnd(arr);
                break;
            case 6:
                quickSortRecursive0(arr, 0, arr.length-1);
                break;
            case 7:
                quickSortIterative0(arr);
                break;
            default:
                System.out.println("err"); // TODO: 2023-11-20 error message
                return;
        }
    }


    public static int[] cropArray(int[] originalArray, int newSize){
        if (newSize >= originalArray.length){
            return originalArray;
        }
        int[] resizedArray = new int[newSize];

        System.arraycopy(originalArray, 0, resizedArray, 0, newSize);

        return resizedArray;
    }

    public static int[] shuffleArray(int[] arr){
        List<Integer> list = intArrToIntegerList(arr);

        Collections.shuffle(list);

        return integerListToIntArr(list);
    }

    public static List<Integer> intArrToIntegerList(int[] arr){
        List<Integer> list = new ArrayList<Integer>(arr.length);
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

    public static int[] integerListToIntArr(List<Integer> list){
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int[] readIntFromFile(String path, int size){
        if (!Files.exists(Paths.get(path))){
            System.out.println("File not found"); // TODO: 2023-11-18 file not found error (maby exit)
            return null;
        }

        int[] arr = new int[size];

        try (Scanner reader = new Scanner(new File(path))){
            for (int i = 0; i < size; i++) {
                if (!reader.hasNextInt()){
                    System.out.println("File dont contain enough integers"); // TODO: 2023-11-18 error (maby exit)
                    return null;
                }
                arr[i] = reader.nextInt();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return arr;
    }

}
