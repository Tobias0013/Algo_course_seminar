package seminar3.task4.RedBlackTreeOld;

public class RedBlackTree <AnyType extends Comparable<? super AnyType>> {
    private RedBlackNode<AnyType> header;
    private RedBlackNode<AnyType> nullNode;
    private final int BLACK = 1;
    private final int RED = 0;
    private RedBlackNode<AnyType> current;
    private RedBlackNode<AnyType> parent;
    private RedBlackNode<AnyType> grand;
    private RedBlackNode<AnyType> great;

    public RedBlackTree() {
        nullNode = new RedBlackNode<>(null);
        nullNode.setLeft(nullNode);
        nullNode.setRight(nullNode);
        header = new RedBlackNode<>(null);
        header.setLeft(nullNode);
        header.setRight(nullNode);
    }

    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     * @param item the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private RedBlackNode<AnyType> rotate(AnyType item, RedBlackNode<AnyType> parent) {
        if (compare(item, parent) < 0) {

            RedBlackNode<AnyType> leftChild = parent.getLeft();
            if (compare(item, leftChild) < 0) {
                parent.setLeft(rotateWithLeft(leftChild)); // LL
                return parent;
            }
            else {
                parent.setLeft(rotateWithRight(leftChild)); // LR
                return parent;
            }
        }
        else {

            RedBlackNode<AnyType> rightChild = parent.getRight();
            if (compare(item, rightChild) < 0) {
                parent.setRight(rotateWithLeft(rightChild)); // RL
                return parent;
            }
            else {
                parent.setRight(rotateWithRight(rightChild)); // RR
                return parent;
            }
        }
    }

    private int compare(AnyType item, RedBlackNode<AnyType> t) {
        if (t == header)
            return 1;
        else
            return item.compareTo(t.getElement());
    }

    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient(AnyType item) {
        // Do the color flip
        current.color = RED;
        current.getLeft().color = BLACK;
        current.getRight().color = BLACK;

        if (parent.color == RED) { // Have to rotate
            grand.color = RED;
            if ((compare(item, grand) < 0) != (compare(item, parent) < 0)) {
                parent = rotate(item, grand); // Start double rotation
                current = rotate(item, great);
                current.color = BLACK;
            }
        }
        header.getRight().color = BLACK; // Make root black
    }

    /**
     * Insert into the tree.
     * @param item the item to insert.
     */
    public void insert(AnyType item) {
        current = parent = grand = header;
        nullNode.setElement(item);

        while (compare(item, current) != 0) {
            great = grand;
            grand = parent;
            parent = current;

            if (compare(item, current) < 0) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }

            // Check if two red children; fix if so
            if (current.getLeft().color == RED && current.getRight().color == RED){
                handleReorient(item);
            }
        }

        // Insertion fails if already present
        if (current != nullNode)
            return;

        current = new RedBlackNode<>(item, nullNode, nullNode);

        // Attach to parent
        if (compare(item, parent) < 0)
            parent.setLeft(current);
        else
            parent.setRight(current);

        handleReorient(item);

    }








    private RedBlackNode<AnyType> rotateWithLeft(RedBlackNode<AnyType> k1){
        RedBlackNode<AnyType> k2 = k1.getLeft();
        k1.setLeft(k2.getRight());
        k2.setRight(k1);
        return k2;
    }

    private RedBlackNode<AnyType> rotateWithRight(RedBlackNode<AnyType> k1){
        RedBlackNode<AnyType> k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        /*
        nullNode.setElement(null);
        nullNode.setRight(null);
        nullNode.setLeft(null);


         */
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(header.getRight());
        }
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree(RedBlackNode<AnyType> t) {
        if (t != nullNode) {
            printTree(t.getLeft());
            System.out.println(t.getElement() + "   Colour: " + t.getColor() + "   Left: " + t.getLeft().getElement()
                    + "   Right: " + t.getRight().getElement());
            printTree(t.getRight());
        }
    }

    public boolean isEmpty(){
        return header == null;
    }

}
