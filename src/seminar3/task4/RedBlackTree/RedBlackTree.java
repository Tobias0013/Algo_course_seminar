package seminar3.task4.RedBlackTree;


public class RedBlackTree extends BalancebleTree {

    public RedBlackTree(int value) {
        super(value);
    }

    private boolean isBlack(Node node){
        return node.getHeight() == 0;
    }

    private boolean isRed(Node node){
        return node.getHeight() == 1;
    }

    private void makeBlack(Node node){
        node.setHeight(0);
    }

    private void makeRed(Node node){
        node.setHeight(1);
    }

    private void setColor(Node node, boolean toRed){
        node.setHeight(toRed ? 1 : 0);
    }

    public void rebalanceInsert(Node node){
        if (node != getRoot()){
            makeRed(node);
            resolveRed(node);
        }
    }

    private void resolveRed(Node node){
        Node parent, sibling, middle, grandparent;
        parent = node.getParent();

        if (isRed(parent)){
            sibling = sibling(parent);

            if (sibling == null || isBlack(sibling)){
                middle = restructure(node);
                makeBlack(middle);
                makeRed(middle.getLeft());
                makeRed(middle.getRight());
            }
            else {
                makeBlack(parent);
                makeBlack(sibling);

                grandparent = parent.getParent();

                if (grandparent != getRoot()){
                    makeRed(grandparent);
                    resolveRed(grandparent);
                }
            }
        }
    }

    public void rebalanceDelete(Node node){
        if (isRed(node)){
            makeBlack(node);
        }
        else if (node != getRoot()) {
            Node sibling = sibling(node);

            if (isInternal(sibling) && (isBlack(sibling) || isInternal(sibling.getLeft()))){
                remedyDoubleBlack(node);
            }
        }
    }

    private void remedyDoubleBlack(Node node){
        Node z = node.getParent();
        Node y = sibling(node);

        if (isBlack(y)){
            if (isRed(node.getLeft()) || isRed(node.getRight())){
                Node x = (isRed(y.getLeft()) ? y.getLeft() : y.getRight());
                Node middle = restructure(x);
                setColor(middle, isRed(z));
                makeBlack(middle.getLeft());
                makeBlack(middle.getRight());

            }
            else {
                makeRed(y);
                if (isRed(z)){
                    makeBlack(z);
                }
                else {
                    if (z != getRoot()){
                        remedyDoubleBlack(z);
                    }
                }
            }
        }
        else {
            rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(node);
        }
    }

    private Node sibling(Node node){
        Node parent = node.getParent();
        if (parent == null){
            return null;
        }

        if (node == parent.getLeft()){
            return parent.getRight();
        }
        else {
            return parent.getLeft();
        }
    }
}
