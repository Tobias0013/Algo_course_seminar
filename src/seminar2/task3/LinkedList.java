package seminar2.task3;

public class LinkedList<E> {
    private int size = -1;
    private Node<E> first = null;
    private Node<E> last = null;

    public LinkedList() {
    }

    public E get(int index){
        return getNode(index).element;
    }

    public void remove(int index){
        Node<E> node = getNode(index);
        Node<E> next = node.next;
        Node<E> prev = node.prev;

        if (next == null){
            last = prev;
        }
        else {
            next.prev = prev;
            node.next = null;
        }


        if (prev == null) {
            first = next;
        }
        else {
            prev.next = next;
            node.prev = null;
        }

        node = null;
        size--;
    }

    public void add(E e){
        if (size < 0){
            Node<E> newNode = new Node<>(null, e, null);
            first = newNode;
            last = newNode;
            size++;
            return;
        }
        Node<E> newNode = new Node<>(last, e, null);
        last.next = newNode;
        last = newNode;
        size++;

    }

    public int size(){
        return size + 1;
    }

    @Override
    public String toString() {
        String s = "";
        Node<E> f = first;
        for (int i = 0; i < size(); i++) {
            if (i == 0){
                s = f.element.toString();
            }
            else {
                s += ", " + f.element.toString();
            }
            f = f.next;
        }
        return s;
    }

    private Node<E> getNode(int index){
        if (index < (size / 2)) {
            Node<E> e = first;
            for (int i = 0; i < index; i++)
                e = e.next;
            return e;
        }
        else {
            Node<E> e = last;
            for (int i = size; i > index; i--)
                e = e.prev;
            return e;
        }
    }
}
