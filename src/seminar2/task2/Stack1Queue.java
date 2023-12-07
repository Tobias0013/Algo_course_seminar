package seminar2.task2;

import java.util.Deque;
import java.util.LinkedList;

public class Stack1Queue<E> {
    Deque<E> queue = new LinkedList<>();

    public void add(E element){
        queue.add(element);
    }

    public E poll(){
        E element = queue.pollLast();
        if (element == null){
            System.out.println("Warning: underflow on stack");
        }
        return element;
    }

    public E peek(){
        return queue.peekLast();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
