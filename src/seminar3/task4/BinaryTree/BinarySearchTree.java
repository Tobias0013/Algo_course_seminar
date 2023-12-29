package seminar3.task4.BinaryTree;

import seminar3.task4.AVLTree.AVLNode;

public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{
    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(BinaryNode<AnyType> root) {
        this.root = root;
    }

    public BinaryNode<AnyType> getRoot() {
        return root;
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

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
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

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;

        if (t.getLeft() == null){
            return t;
        }
        return findMin(t.getLeft());
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null)
            return null;

        if (t.getRight() == null){
            return t;
        }
        return findMin(t.getRight());
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null){
            return new BinaryNode<>(x);
        }

        int compareResult = x.compareTo(t.getElement());

        if (compareResult < 0){
            t.setLeft(insert(x, t.getLeft()));
        }
        else if (compareResult > 0) {
            t.setRight(insert(x, t.getRight()));
        }
        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return null;

        int compareResult = x.compareTo(t.getElement());


        if (compareResult < 0){
            t.setLeft(remove(x, t.getLeft()));
        }
        else if (compareResult > 0) {
            t.setRight(remove(x, t.getRight()));
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
        return t;
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null){
            printTree(t.getLeft());
            System.out.println(t.getElement());
            printTree(t.getRight());
        }
    }

    public void inorder(BinaryNode<AnyType> node){
        if (node != null){
            inorder(node.getLeft());
            printNode(node);
            inorder(node.getRight());
        }
    }

    private void printNode(BinaryNode<AnyType> node) {
        if (node.getElement() == root.getElement()) {
            System.out.print("Root Node: " + node.getElement());
        } else {
            System.out.print("Current Node: " + node.getElement());
        }

        printNodeInformation(node.getLeft(), ", Left Child: ");
        printNodeInformation(node.getRight(), ", Right Child: ");

        System.out.println();
    }

    private void printNodeInformation(BinaryNode<AnyType> node, String string) {
        if (node != null) {
            System.out.print(string + node.getElement());
        }
    }
}
