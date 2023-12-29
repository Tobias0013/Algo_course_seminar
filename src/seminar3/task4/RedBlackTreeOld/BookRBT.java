package seminar3.task4.RedBlackTreeOld;

public class BookRBT<AnyType extends Comparable<? super AnyType>> {

    private static final int BLACK = 1; // BLACK must be 1
    private static final int RED = 0;

    private RedBlackNode<AnyType> header;
    private RedBlackNode<AnyType> nullNode;

    /**
     * Construct the tree.
     */
    public BookRBT() {
        nullNode = new RedBlackNode<>(null);
        nullNode.left = nullNode.right = nullNode;
        header = new RedBlackNode<>(null);
        header.left = header.right = nullNode;
    }

    private static class RedBlackNode<AnyType> {

        // Constructors
        RedBlackNode(AnyType theElement) {
            this(theElement, null, null);
        }

        RedBlackNode(AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
            color = 1;
        }

        AnyType element; // The data in the node
        RedBlackNode<AnyType> left; // Left child
        RedBlackNode<AnyType> right; // Right child
        int color; // Color
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
            return parent.left = compare(item, parent.left) < 0 ?
                    rotateWithLeftChild(parent.left) : // LL
                    rotateWithRightChild(parent.left); // LR
        } else {
            return parent.right = compare(item, parent.right) < 0 ?
                    rotateWithLeftChild(parent.right) : // RL
                    rotateWithRightChild(parent.right); // RR
        }
    }

    private RedBlackNode<AnyType> rotateWithLeftChild(RedBlackNode<AnyType> k1){
        RedBlackNode<AnyType> k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;
        return k2;
    }

    private RedBlackNode<AnyType> rotateWithRightChild(RedBlackNode<AnyType> k1){
        RedBlackNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if it is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare(AnyType item, RedBlackNode<AnyType> t) {
        if (t == header) {
            return 1;
        } else {
            return item.compareTo(t.element);
        }
    }

    // Used in insert routine and its helpers
    private RedBlackNode<AnyType> current;
    private RedBlackNode<AnyType> parent;
    private RedBlackNode<AnyType> grand;
    private RedBlackNode<AnyType> great;

    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient(AnyType item) {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED) { // Have to rotate
            grand.color = RED;
            if ((compare(item, grand) < 0) != (compare(item, parent) < 0)) {
                parent = rotate(item, grand); // Start double rotate
                current = rotate(item, great);
                current.color = BLACK;
            }
        }
        header.right.color = BLACK; // Make root black
    }

    /**
     * Insert into the tree.
     * @param item the item to insert.
     */
    public void insert(AnyType item) {
        current = parent = grand = header;
        nullNode.element = item;

        while (compare(item, current) != 0) {
            great = grand;
            grand = parent;
            parent = current;
            current = compare(item, current) < 0 ? current.left : current.right;

            // Check if two red children; fix if so
            if (current.left.color == RED && current.right.color == RED) {
                handleReorient(item);
            }
        }

        // Insertion fails if already present
        if (current != nullNode) {
            return;
        }

        current = new RedBlackNode<>(item, nullNode, nullNode);

        // Attach to parent
        if (compare(item, parent) < 0) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        handleReorient(item);
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(header.right);
        }
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree(RedBlackNode<AnyType> t) {
        if (t != nullNode) {
            printTree(t.left);
            System.out.println(t.element + "   Colour: " + t.color + "   Left: " + t.left.element
                    + "   Right: " + t.right.element);
            printTree(t.right);
        }
    }

    public boolean isEmpty(){
        return header == null;
    }
}

