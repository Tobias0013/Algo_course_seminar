package seminar3.task4.AVLTree;

public class AVLTree <AnyType extends Comparable<? super AnyType>> {
    private final int ALLOWED_IMBALANCE = 1;
    private AVLNode<AnyType> root;

    public AVLTree() {
        root = null;
    }

    public AVLTree(AVLNode<AnyType> root) {
        this.root = root;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            System.out.println("Error: tree is empty");
        }
        return findMin(root).getElement();
    }

    public AnyType findMax() {
        if (isEmpty()) {
            System.out.println("Error: tree is empty");
        }
        return findMax(root).getElement();
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty()){
            System.out.println("tree is empty");
        }
        else {
            printTree(root);
        }
    }

    private boolean contains(AnyType x, AVLNode<AnyType> t) {
        /* Figure 4.18 */

        if (t == null)
            return false;

        int compareResult = x.compareTo(t.getElement());

        if (compareResult < 0){
            return contains(x, t.getLeft());
        }
        else if (compareResult > 0) {
            return contains(x, t.getRight());
        }
        else {
            return true;
        }
    }

    private AVLNode<AnyType> findMin(AVLNode<AnyType> t) {
        if (t == null)
            return null;

        if (t.getLeft() == null){
            return t;
        }
        return findMin(t.getLeft());
    }

    private AVLNode<AnyType> findMax(AVLNode<AnyType> t) {
        if (t == null)
            return null;

        if (t.getRight() == null){
            return t;
        }
        return findMin(t.getRight());
    }

    private AVLNode<AnyType> insert(AnyType x, AVLNode<AnyType> t) {
        if (t == null) {
            return new AVLNode<>(x);
        }

        int compareResult = x.compareTo(t.getElement());

        if (compareResult < 0) {
            t.setLeft(insert(x, t.getLeft()));
        } else if (compareResult > 0) {
            t.setRight(insert(x, t.getRight()));
        }
        return balance(t);
    }
    
    private AVLNode<AnyType> balance(AVLNode<AnyType> t){
        if (t == null)
            return t;

        if (height(t.getLeft()) - height(t.getRight()) > ALLOWED_IMBALANCE){ //left height bigger
            if (height(t.getLeft().getRight()) > height(t.getLeft().getLeft())){
                t = doubleWithLeft(t);
            }
            else {
                t = rotateWithLeft(t);
            }
        }
        else if (height(t.getRight()) - height(t.getLeft()) > ALLOWED_IMBALANCE){ //right height bigger
            if (height(t.getRight().getLeft()) > height(t.getRight().getRight())){
                t = doubleWithRight(t);
            }
            else {
                t = rotateWithRight(t);
            }
        }

        t.setHeight(Math.max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }

    private AVLNode<AnyType> rotateWithLeft(AVLNode<AnyType> k1){
        AVLNode<AnyType> k2 = k1.getLeft();
        k1.setLeft(k2.getRight());
        k2.setRight(k1);
        return k2;
    }

    private AVLNode<AnyType> rotateWithRight(AVLNode<AnyType> k1){
        AVLNode<AnyType> k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }

    private AVLNode<AnyType> doubleWithLeft(AVLNode<AnyType> k1){
        AVLNode<AnyType> k2 = k1.getLeft();

        rotateWithRight(k2);
        return rotateWithLeft(k1);
    }

    private AVLNode<AnyType> doubleWithRight(AVLNode<AnyType> k1){
        AVLNode<AnyType> k2 = k1.getRight();

        rotateWithLeft(k2);
        return rotateWithRight(k1);
    }
    
    private int height(AVLNode<AnyType> t){
        if (t == null) {
            return -1;
        } else {
            return t.getHeight();
        }
    }

    private AVLNode<AnyType> remove(AnyType x, AVLNode<AnyType> t) {
        if (t == null)
            return null;

        int compareResult = x.compareTo(t.getElement());


        if (compareResult < 0){
            return remove(x, t.getLeft());
        }
        else if (compareResult > 0) {
            return remove(x, t.getRight());
        }
        else if (t.getRight() != null && t.getLeft() != null) { //two children
            t.setElement(findMin(t.getRight()).getElement());
            t.setRight(remove(t.getElement(), t.getRight()));
        }
        else {
            if (t.getLeft() != null) {
                t = t.getLeft();
            }
            else {
                t = t.getRight();
            }
        }
        return balance(t);
    }

    private void printTree(AVLNode<AnyType> t) {
        if (t != null){
            printTree(t.getLeft());
            System.out.println(t.getElement());
            printTree(t.getRight());
        }
    }

}
