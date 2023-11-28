package seminar1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static seminar1.util.SortUtil.*;
import static seminar1.util.BinarySearch.*;

public class Main {
    public static void main(String[] args) {
        String path = "src/seminar1/files/random_numbers.txt";
        Scanner sc = new Scanner(System.in);
        String input;
        int arrLen;
        while (true){
            System.out.println("Chose what you want to do:");
            System.out.println("0. Run Insertion Sort Recursive");
            System.out.println("1. Run Insertion Sort Iterative");
            System.out.println("2. Run Quick Sort Recursive pivot median-of-three");
            System.out.println("3. Run Quick Sort Iterative pivot median-of-three");
            System.out.println("4. Run Quick Sort Recursive pivot Random");
            System.out.println("5. Run Quick Sort Iterative pivot Random");
            System.out.println("6. Run Quick Sort Recursive pivot arr[0]");
            System.out.println("7. Run Quick Sort Iterative pivot arr[0]");
            System.out.println("8. Run BinarySearch");
            System.out.println("9. Run Automated Test (test everything");

            input = sc.next();

            if (isInteger(input)){
                int i = Integer.parseInt(input);
                if (i >= 0 && i <= 7){
                    arrLen = choseArrLen(sc);
                    printResult(path, arrLen, i);
                }
            }

            switch (input){
                case "8":
                    arrLen = choseArrLen(sc);

                    break;
                case "9":
                    automatedAnalysis(path);
                    automatedAnalysisBinSearch(path);
                    return;
                default:
                    System.out.println("you need to input a valid choose");
                    break;
            }
        }
    }

    public static int choseArrLen(Scanner sc){
        String input;
        do {
            System.out.println("Enter Array length");
            input = sc.next();
            if (!isInteger(input)){
                System.out.println("Enter a valid lenght");
            }
            else {
                return Integer.parseInt(input);
            }
        } while (true);
    }

    public static void printResult(String path, int arrLen, int mode){
        if (mode == 8) {// run binary search
            int[] arr = readIntFromFile(path, arrLen);
            double time = analyzeBinSearch(arr, 1);
            System.out.println("The time it took to run the algorithm is: " + time + " ms \n");

        }
        int[] arr = readIntFromFile(path, arrLen);
        double time = analyze(arr, 1, mode);
        System.out.println("The time it took to run the algorithm is: " + time + " ms \n");
    }

    public static boolean isInteger(String input) {
        try {
            // Attempt to parse the input as an integer
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // Input is not a valid integer
            return false;
        }
    }

    public static void automatedAnalysisBinSearch(String path){
        int times = 10; // times to run algo
        double[] duration = new double[5]; // duration of algo in ms

        int[] sizes = {1_000_000, 100_000, 10_000, 1_000, 100};

        int[] arr = readIntFromFile(path, 1_000_000);

        for (int i = 0; i < sizes.length; i++) {
            arr = cropArray(arr, sizes[i]);

            duration[i] = analyzeBinSearch(arr, times);
        }

        //print result
        System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", "Algorithm used",
                "1 000 000", "100 000", "10 000", "1 000", "100");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", "binary search",
                duration[0], duration[1], duration[2], duration[3], duration[4]);


    }

    public static double analyzeBinSearch(int[] arr, int times){
        double[] durations = new double[times];

        Random rnd = new Random();
        int x;

        for (int i = 0; i < times; i++) {
            arr = shuffleArray(arr);
            x = arr[rnd.nextInt(arr.length)];

            long startTime = System.nanoTime();

            binarySearch(arr, 0, arr.length-1, x);

            long endTime = System.nanoTime();

            double duration = (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

            durations[i] = duration;
        }

        return calculateAverage(durations);

    }


    private static void automatedAnalysis(String path){

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
                System.out.println("err runSort mode not found");
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
            System.out.println("File not found");
            return null;
        }

        int[] arr = new int[size];

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

}
