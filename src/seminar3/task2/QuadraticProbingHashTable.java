package seminar3.task2;

import java.util.Arrays;

public class QuadraticProbingHashTable {
    private static final int DEFAULT_TABLE_SIZE = 10;
    private Integer[] arr;
    private int currentSize;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        arr = new Integer[size];
        currentSize = 0;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void insert(Integer x){
        int pos = myHash(x);
        int i = 1;
        int tmp = pos;

        while (arr[tmp] != null){
            tmp = (pos + i * i) % arr.length;
            i++;
        }
        arr[tmp] = x;
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

    public void reHash(){
        QuadraticProbingHashTable table = new QuadraticProbingHashTable(arr.length * 2);
        for (Integer i : arr) {
            if (i != null)
                table.insert(i);
        }
        arr = table.getArr();
    }

    public void reHash(int size){
        QuadraticProbingHashTable table = new QuadraticProbingHashTable(size);
        for (Integer i : arr) {
            table.insert(i);
        }
        arr = table.getArr();
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
