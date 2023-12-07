package seminar2.task2;

import java.util.Stack;

public class Queue1Stack<E> {
    Stack<E> stack = new Stack<>();

    public void add(E element){
        stack.push(element);
    }

    public E poll(){
        E element;
        try {
            element = stack.firstElement();
            stack.remove(0);
        } catch (Exception e){
            System.out.println("Warning: underflow on queue");
            element = null;
        }
        return element;
    }

    public E peek(){
        return stack.firstElement();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
