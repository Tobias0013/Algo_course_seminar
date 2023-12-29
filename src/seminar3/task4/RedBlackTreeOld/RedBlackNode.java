package seminar3.task4.RedBlackTreeOld;

public class RedBlackNode <AnyType> {
    private AnyType element;
    private RedBlackNode<AnyType> left;
    private RedBlackNode<AnyType> right;
    int color;

    public RedBlackNode(AnyType element) {
        this(element, null, null);
    }

    public RedBlackNode(AnyType element, RedBlackNode<AnyType> left, RedBlackNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.color = 1;
    }

    public AnyType getElement() {
        return element;
    }

    public void setElement(AnyType element) {
        this.element = element;
    }

    public RedBlackNode<AnyType> getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode<AnyType> left) {
        this.left = left;
    }

    public RedBlackNode<AnyType> getRight() {
        return right;
    }

    public void setRight(RedBlackNode<AnyType> right) {
        this.right = right;
    }

    public int getColor() {
        return color;
    }

}
