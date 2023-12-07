# Time complexity Task 3

## remove()

## getNode()

    private Node<E> getNode(int index){
        if (index < (size / 2)) {
            Node<E> e = first;                  //O(1)
            for (int i = 0; i < index; i++)     //O(n/2)
                e = e.next;                     //O(1)
            return e;
        }
        else {
            Node<E> e = last;                   //O(1)
            for (int i = size; i > index; i--)  //O(n/2)
                e = e.prev;                     //O(1)
            return e;
        }
    }

Worst case time complexity of O(n) since O(n/2) => O(n)

---

    public void remove(int index){
        Node<E> node = getNode(index);          //O(n)
        Node<E> next = node.next;           //O(1)
        Node<E> prev = node.prev;           //O(1)

        if (next == null){                  //O(1)
            last = prev;
        }
        else {                              //O(1)
            next.prev = prev;
            node.next = null;
        }


        if (prev == null) {                 //O(1)
            first = next;
        }   
        else {                              //O(1)
            prev.next = next;
            node.prev = null;
        }

        node = null;                        //O(1)
        size--;                             //O(1)
    }

Worst case time complexity of O(1) or O(n) if you cont the time complexity of getNode();

---

## add()

    public void add(E e){
        if (size < 0){
            Node<E> newNode = new Node<>(null, e, null);    //O(1)
            first = newNode;                                //O(1)
            last = newNode;                                 //O(1)
            size++;                                         //O(1)
            return;
        }
        Node<E> newNode = new Node<>(last, e, null);
        last.next = newNode;                                //O(1)
        last = newNode;                                     //O(1)
        size++;                                             //O(1)

    }

Worst case time complexity of O(1)











