package seminar3.task4.AVLTree;

public class AVLNode <AnyType> {
    private AnyType element;
    private AVLNode<AnyType> left;
    private AVLNode<AnyType> right;
    private int height;

    public AVLNode(AnyType element) {
        this(element, null, null);
    }

    public AVLNode(AnyType element, AVLNode<AnyType> left, AVLNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public AnyType getElement() {
        return element;
    }

    public void setElement(AnyType element) {
        this.element = element;
    }

    public AVLNode<AnyType> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<AnyType> left) {
        this.left = left;
    }

    public AVLNode<AnyType> getRight() {
        return right;
    }

    public void setRight(AVLNode<AnyType> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
