package seminar2.task2;

import java.util.Deque;
import java.util.LinkedList;

public class Stack2Queue<E> extends Stack1Queue<E>{
    Deque<E> queue = new LinkedList<>();

    @Override
    public E poll() {
        queue.add(super.poll());
        return queue.poll();
    }
}
