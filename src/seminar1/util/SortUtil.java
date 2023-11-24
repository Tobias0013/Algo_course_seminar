package seminar1.util;

import java.util.Random;
import java.util.Stack;

public class SortUtil {
    //------------------------------Quick Sort Median3------------------------------

    /**
     *
     * @param arr int array to be sorted
     * @param left left most arr index
     * @param right right most arr index (arr.length-1)
     */
    public static void quickSortRecursive(int[] arr, int left, int right){
        if(left + 10 <= right) {

            int pivot = pivotMedian3(arr, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; ) {
                while(i + 1 <= right && arr[ ++i ] < pivot){}
                while(j - 1 >= 0 && arr[ --j ] > pivot){}

                if( i < j )
                    swapReferences( arr, i, j );
                else
                    break;
            }

            swapReferences(arr, i, right - 1 );

            quickSortRecursive( arr, left, i - 1); // Sort small elements
            quickSortRecursive( arr, i + 1, right); // Sort large elements
        }
        else { // Do an insertion sort on the subarray
            insertionSortRecursive(arr, left, right);
        }

    }

    public static void quickSortIterative(int[] arr){
        if(arr.length >= 10) {

            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(arr.length - 1);


            while (!stack.isEmpty()) {
                int right = stack.pop();
                int left = stack.pop();

                int pivot = pivotMedian3(arr, left, right);

                //partition
                int i = left, j = right - 1;
                while (true) {
                    while (i + 1 <= right && arr[++i] < pivot) {
                    }
                    while (j - 1 >= 0 && arr[--j] > pivot) {
                    }

                    if (i < j) {
                        swapReferences(arr, i, j);
                    } else {
                        break;
                    }
                }
                //swap back pivot with next from left
                if (i != right) {
                    swapReferences(arr, right - 1, i);
                }

                //update stack for next iteration
                if (i - 1 > left) {
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
            insertionSortIterative(arr);
        }

    }

    private static int pivotMedian3(int[] arr, int left, int right) {
        int center = (left + right) / 2;

        if (arr[center] < arr[left]) {
            swapReferences(arr, left, center);
        }
        if (arr[right] < arr[left]) {
            swapReferences(arr, left, right);
        }
        if (arr[right] < arr[center]) {
            swapReferences(arr, center, right);
        }

        // Place pivot at position right - 1
        swapReferences(arr, center, right - 1);
        return arr[right - 1];
    }

    //------------------------------------------------------------------------------

    //------------------------------Quick Sort Rnd------------------------------

    public static void quickSortRecursiveRnd(int[] arr, int left, int right){
        if(left + 10 <= right) {

            int pivot = pivotRnd(arr, left, right);

            // Begin partitioning
            int i = left - 1, j = right;
            for( ; ; ) {
                while(i + 1 <= right && arr[ ++i ] < pivot){}
                while(j - 1 >= 0 && arr[ --j ] > pivot){}

                if( i < j )
                    swapReferences( arr, i, j );
                else
                    break;
            }

            swapReferences(arr, i, right);

            quickSortRecursiveRnd( arr, left, i - 1); // Sort small elements
            quickSortRecursiveRnd( arr, i + 1, right); // Sort large elements
        }
        else { // Do an insertion sort on the subarray
            insertionSortRecursive(arr, left, right);
        }
    }

    public static void quickSortIterativeRnd(int[] arr){
        if(arr.length >= 10) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(arr.length-1);


            while (!stack.isEmpty()){
                int right = stack.pop();
                int left = stack.pop();

                int pivot = pivotRnd(arr, left, right);

                //partition
                int i = left - 1, j = right;
                while (true){
                    while(i + 1 <= right && arr[ ++i ] < pivot){}
                    while(j - 1 >= 0 && arr[ --j ] > pivot){}

                    if (i < j) {
                        swapReferences(arr, i, j);
                    }
                    else{
                        break;
                    }
                }
                //swap back pivot with next from left
                if (i != right) {
                    swapReferences(arr, right, i);
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
            insertionSortIterative(arr);
        }
    }

    private static int pivotRnd(int[] arr, int left, int right){
        Random rnd = new Random();
        swapReferences(arr, rnd.nextInt(left, right + 1), right);
        return arr[right];

    }

    //--------------------------------------------------------------------------

    //------------------------------Quick Sort 0------------------------------

    public static void quickSortRecursive0(int[] arr, int left, int right){
        if(left + 10 <= right) {
            int pivot = pivot0(arr, left, right);

            // Begin partitioning
            int i = left - 1, j = right;
            for( ; ; ) {
                while(i + 1 <= right && arr[ ++i ] < pivot){}
                while(j - 1 >= 0 && arr[ --j ] > pivot){}

                if( i < j )
                    swapReferences( arr, i, j );
                else
                    break;
            }

            swapReferences(arr, i, right);

            quickSortRecursive0( arr, left, i - 1); // Sort small elements
            quickSortRecursive0( arr, i + 1, right); // Sort large elements
        }
        else { // Do an insertion sort on the subarray
            insertionSortRecursive(arr, left, right);
        }
    }

    public static void quickSortIterative0(int[] arr){
        if(arr.length >= 10) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(arr.length-1);


            while (!stack.isEmpty()){
                int right = stack.pop();
                int left = stack.pop();

                int pivot = pivot0(arr, left, right);

                //partition
                int i = left - 1, j = right;
                while (true){
                    while(i + 1 <= right && arr[ ++i ] < pivot){}
                    while(j - 1 >= 0 && arr[ --j ] > pivot){}

                    if (i < j) {
                        swapReferences(arr, i, j);
                    }
                    else{
                        break;
                    }
                }
                //swap back pivot with next from left
                if (i != right) {
                    swapReferences(arr, right, i);
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
            insertionSortIterative(arr);
        }
    }

    private static int pivot0(int[] arr, int left, int right){
        swapReferences(arr, left, right);
        return arr[right];
    }

    //------------------------------------------------------------------------

    //------------------------------Insertion Sort------------------------------

    public static void insertionSortRecursive(int[] arr, int left, int right){
        // if right - left is only one long (right - left <= 0)
        if (left >= right){
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

    /**
     *
     * @param arr int array to be sorted
     */
    public static void insertionSortIterative(int[] arr){
        for (int p = 1; p < arr.length; p++) {
            int tmp = arr[p];
            int j;

            for (j = p; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = tmp;
        }
    }

    //--------------------------------------------------------------------------

    private static void swapReferences(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
