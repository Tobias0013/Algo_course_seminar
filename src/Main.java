import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {3,2,3,4,5,1,2,6};
                    // 1,2,2,3,3,4,5,6

        insertionSortRecursive(a, a.length - 1);
        System.out.println();
        System.out.println(Arrays.toString(a));

    }

    //---------------------------------------------------------

    public static void quickSortIterative(){

    }

    public static <AnyType> void quickSortRecursive(AnyType[] a, int left, int right){

    }

    public static <AnyType extends Comparable<? super AnyType>> void insertionSortIterative(AnyType[] a){
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            int j;

            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }

            a[j] = tmp;
        }
    }

    /**
     *
     * @param a an array to be sorted
     * @param n the nof elements in array
     */
    public static void insertionSortRecursive(Integer[] a, int n){
        // if a is only one long
        if (n <= 0){
            return;
        }

        // recursive sort the first n-1 element
        insertionSortRecursive(a, n-1);
        System.out.println(Arrays.toString(a));

        // last is the int to sort
        int last = a[n];
        // j is the position to compare with
        int j = n-1;

        while (j >= 0 && a[j] > last){
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = last;
    }


}
