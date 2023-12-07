package seminar2.task2;

import java.util.Stack;

public class Queue2Stack<E> extends Queue1Stack<E>{

    Stack<E> stack = new Stack<>();

    @Override
    public E poll() {
        stack.push(super.poll());
        return stack.pop();
    }
}
