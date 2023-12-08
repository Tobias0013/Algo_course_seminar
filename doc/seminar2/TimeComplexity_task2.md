# Time complexity Task 2

## Class Queue using 1 Stack

    public class Queue1Stack<E> {
        Stack<E> stack = new Stack<>();
        public void add(E element){
            stack.push(element);                                   //O(1)
        }
    
        public E poll(){
            E element;
            try {
                element = stack.firstElement();                    //O(1)
                stack.remove(0);                                   //O(1)
            } catch (Exception e){
                System.out.println("Warning: underflow on queue"); //O(1)
                element = null;                                    //O(1)
            }
            return element;                                        //O(1)
        }
    
        public E peek(){
            return stack.firstElement();                           //O(1)
        }
    
        public int size(){
            return stack.size();                                   //O(1)
        }
    
        public boolean isEmpty(){
            return stack.isEmpty();                                //O(1)
        }
    }

All the methods have a time complexity of O(1)

---

## Class Queue using 2 Stacks

    public class Queue2Stack<E> extends Queue1Stack<E>{
    
        Stack<E> stack = new Stack<>();
    
        @Override
        public E poll() {
            stack.push(super.poll());       //O(1)
            return stack.pop();             //O(1)
        }
    }

This class extends the class Queue1Stack so complexity same for methods that aren't overriden.

All the methods have a time complexity of O(1)

---

## Class Stack using 1 Queue

    public class Stack1Queue<E> {
        Deque<E> queue = new LinkedList<>();
    
        public void add(E element){
            queue.add(element);                                    //O(1)
        }
    
        public E poll(){
            E element = queue.pollLast();                          //O(1)
            if (element == null){                                  //O(1)
                System.out.println("Warning: underflow on stack");
            }
            return element;
        }
    
        public E peek(){
            return queue.peekLast();                               //O(1)
        }
    
        public int size(){
            return queue.size();                                   //O(1)
        }
    
        public boolean isEmpty(){
            return queue.isEmpty();                                //O(1)
        }
    }

All the methods have a time complexity of O(1)

---

## Class Stack using 2 Queues

    public class Stack2Queue<E> extends Stack1Queue<E>{
        Deque<E> queue = new LinkedList<>();
    
        @Override
        public E poll() {
            queue.add(super.poll());        //O(1)
            return queue.poll();            //O(1)
        }
    }

This class extends the class Queue1Stack so complexity same for methods that aren't overriden.

All the methods have a time complexity of O(1)
