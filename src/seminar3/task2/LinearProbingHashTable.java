package seminar3.task2;

import java.util.Arrays;

public class LinearProbingHashTable {
    private static final int DEFAULT_TABLE_SIZE = 10;
    Integer[] arr;
    int currentSize;

    public LinearProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public LinearProbingHashTable(int size) {
        arr = new Integer[size];
        currentSize = 0;
    }

    public void insert(Integer x){
        int pos = myHash(x);

        while (arr[pos] != null){
            if (pos + 1 >= arr.length)
                pos = 0;
            else
                pos++;
        }
        arr[pos] = x;
        currentSize++;
    }

    public int myHash(Integer x){
        int hashVal = x.hashCode();
        hashVal %= arr.length;

        if (hashVal < 0){
            hashVal += arr.length;
        }
        return hashVal;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }


}
