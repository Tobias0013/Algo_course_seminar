package seminar3.task4.BinaryTree;

public class BinaryNode<AnyType> {
    private AnyType element;
    private BinaryNode<AnyType> left;
    private BinaryNode<AnyType> right;

    public BinaryNode(AnyType element) {
        this(element, null, null);
    }

    public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public AnyType getElement() {
        return element;
    }

    public void setElement(AnyType element) {
        this.element = element;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<AnyType> left) {
        this.left = left;
    }

    public BinaryNode<AnyType> getRight() {
        return right;
    }

    public void setRight(BinaryNode<AnyType> right) {
        this.right = right;
    }
}
