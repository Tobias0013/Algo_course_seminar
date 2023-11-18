import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(test());

    }

    public static boolean test(){
        Integer[] arr = {29, 12, 45, 7, 83, 56, 4, 91, 20, 63, 17, 42, 50, 5, 74, 30, 68, 22, 11, 97, 34, 2, 78, 51, 16, 88, 40, 75, 8, 59, 25, 69, 14, 37, 93, 1, 61, 87, 19, 47, 82, 36, 71, 10, 55, 98, 26, 64, 13, 52};
        Integer[] cor = {29, 12, 45, 7, 83, 56, 4, 91, 20, 63, 17, 42, 50, 5, 74, 30, 68, 22, 11, 97, 34, 2, 78, 51, 16, 88, 40, 75, 8, 59, 25, 69, 14, 37, 93, 1, 61, 87, 19, 47, 82, 36, 71, 10, 55, 98, 26, 64, 13, 52};
        Integer[] tmp;
        Arrays.sort(cor);

        tmp = arr;
        quickSortIterative(tmp);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = arr;
        quickSortRecursive(tmp, 0, tmp.length-1);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = arr;
        insertionSortIterative(tmp);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        tmp = arr;
        insertionSortRecursive(tmp, 0, tmp.length-1);
        if (!Arrays.equals(cor, tmp)){
            return false;
        }

        return true;
    }



    //---------------------------------------------------------

    /**
     *
     * @param arr Integer array to be sorted
     * @param left left most arr index
     * @param right right most arr index (arr.length-1)
     */
    public static void quickSortRecursive(Integer[] arr, int left, int right){
        if(left + 10 <= right) {
            Integer pivot = median3(arr, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; ) {
                while(arr[ ++i ] < pivot){}
                while(arr[ --j ] > pivot){}
                if( i < j )
                    swapReferences( arr, i, j );
                else
                    break;
            }

            swapReferences( arr, i, right - 1 ); // Restore pivot
            quickSortRecursive( arr, left, i - 1 ); // Sort small elements
            quickSortRecursive( arr, i + 1, right ); // Sort large elements
        }
        else { // Do an insertion sort on the subarray
            insertionSortRecursive(arr, left, right);
        }
    }

    public static void quickSortIterative(Integer[] arr){
        if(arr.length >= 10) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(arr.length-1);


            while (!stack.isEmpty()){
                int right = stack.pop();
                int left = stack.pop();

                Integer pivot = median3(arr, left, right);

                //partition
                int i = left, j = right - 1;
                while (true){
                    while(arr[++i] < pivot){}
                    while(arr[--j] > pivot){}

                    if (i < j) {
                        swapReferences(arr, i, j);
                    }
                    else{
                        break;
                    }
                }
                //swap back pivot with next from left
                if (i != right) {
                    //set i to next from left which is pivot index
                    swapReferences(arr, right - 1, i);
                }

                //update stack for next iteration
                if (i - 1 > left){
                    stack.push(left);
                    stack.push(i - 1);
                }

                if (i + 1 < right) {
                    stack.push(i + 1);
                    stack.push(right);
                }
            }
        }
        else { // Do an insertion sort on the subarray
            insertionSortRecursive(arr, 0, arr.length-1);
        }
    }

    private static Integer median3(Integer[] a, int left, int right) {
        int center = (left + right) / 2;

        if (a[center] < a[left]) {
            swapReferences(a, left, center);
        }
        if (a[right] < a[left]) {
            swapReferences(a, left, right);
        }
        if (a[right] < a[center]) {
            swapReferences(a, center, right);
        }

        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private static void swapReferences(Integer[] a, int index1, int index2) {
        Integer temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    /**
     *
     * @param arr Integer array to be sorted
     */
    public static void insertionSortIterative(Integer[] arr){
        for (int p = 1; p < arr.length; p++) {
            Integer tmp = arr[p];
            int j;

            for (j = p; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = tmp;
        }
    }

    public static void insertionSortRecursive(Integer[] arr, int left, int right){
        // if right - left is only one long
        if (right - left <= 0){
            return;
        }

        // recursive sort the first n-1 element
        insertionSortRecursive(arr, left, right-1);

        // last is the int to sort
        int last = arr[right];
        // j is the position to compare with
        int j = right-1;

        while (j >= 0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }


}
