package seminar3.task2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable {
    private static final int DEFAULT_TABLE_SIZE = 10;

    LinkedList<Integer>[] list;
    int currentSize;

    public SeparateChainingHashTable() {
        list = new LinkedList[DEFAULT_TABLE_SIZE];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }    }

    public SeparateChainingHashTable(int size) {
        list = new LinkedList[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void insert(Integer x){
        LinkedList<Integer> whichList = list[myHash(x)];
        if (!whichList.contains(x)){
            whichList.add(x);
        }
        currentSize++;
    }

    public int myHash(Integer x){
        int hashVal = x.hashCode();
        hashVal %= list.length;

        if (hashVal < 0){
            hashVal += list.length;
        }
        return hashVal;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
