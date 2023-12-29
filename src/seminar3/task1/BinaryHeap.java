package seminar3.task1;

import java.util.Arrays;

public class BinaryHeap {
    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize; // Number of elements in heap

    private Integer [] array; // The heap array
    
    public BinaryHeap() {
        array = new Integer[DEFAULT_CAPACITY];
        currentSize = 0;
    }
    
    public BinaryHeap(int capacity) { /* See online code */
        array = new Integer[capacity + 1];
        currentSize = 0;
    }

    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap(Integer[] items) {
        currentSize = items.length;
        array = new Integer[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (Integer item : items) {
            array[i++] = item;
        }

        buildHeap();
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    public Integer[] getArray() {
        return array;
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert(Integer x) { /* Figure 6.8 */
        if (currentSize == array.length - 1){
            System.out.println("Error: Insert, arr is full");
            //enlargeArray();
        }

        //perlocate up

        Integer hole = ++currentSize;
        for (array[0] = x; x < array[hole/2]; hole /= 2){
            array[hole] = array[hole/2];
        }
        array[hole] = x;

         /*
        int hole = ++currentSize;
        for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;

          */
    }

    public boolean isEmpty() { /* See online code */
        return currentSize == 0;
    }

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        Integer tmp = array[hole];

        for ( ; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;

            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }

            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            }
            else {
                break;
            }
        }

        array[hole] = tmp;
    }

    public void printPreOrder(){
        System.out.print("Pre order: ");
        preOrder(1);
        System.out.println();
    }

    private void preOrder(int pos){
        System.out.print(array[pos] + ", ");

        if (pos * 2 < currentSize + 1 && array[pos * 2] != null){
            preOrder(pos * 2);
        }

        if (pos * 2 + 1 < currentSize + 1 && array[pos * 2 + 1] != null){
            preOrder(pos * 2 + 1);
        }
    }
    
    public void printInOrder(){
        System.out.print("In order: ");
        inOrder(1);
        System.out.println();
    }

    private void inOrder(int pos){
        if (pos * 2 < currentSize + 1 && array[pos * 2] != null){
            inOrder(pos * 2);
        }

        System.out.print(array[pos] + ", ");

        if (pos * 2 + 1 < currentSize + 1 && array[pos * 2 + 1] != null){
            inOrder(pos * 2 + 1);
        }
    }

    public void printPostOrder(){
        System.out.print("Post order: ");
        postOrder(1);
        System.out.println();
    }

    private void postOrder(int pos){
        if (pos * 2 < currentSize + 1 && array[pos * 2] != null){
            postOrder(pos * 2);
        }

        if (pos * 2 + 1 < currentSize + 1 && array[pos * 2 + 1] != null){
            postOrder(pos * 2 + 1);
        }

        System.out.print(array[pos] + ", ");
    }

    public void printLevelOrder(){
        System.out.print("Level order: ");
        for (int i = 1; i < currentSize + 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}






















