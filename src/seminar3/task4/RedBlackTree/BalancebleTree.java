package seminar3.task4.RedBlackTree;

public class BalancebleTree {
    private Node root;

    public BalancebleTree(int value){
        root = new Node(value);
    }

    public Node getRoot(){
        return root;
    }

    public Node search(int key){
        Node nodeFound = searchHelper(root, key);
        rebalaceAccess(nodeFound);
        return nodeFound;
    }

    private Node searchHelper(Node node, int key){
        if (key == node.getValue()) {
            return node;
        }
        else if (key < node.getValue()){
            if (node.getLeft() == null)
                return node; // borde kanske returnera null

            return searchHelper(node.getLeft(), key);
        }
        else{
            if (node.getRight() == null)
                return node; // borde kanske returnera null

            return searchHelper(node.getRight(), key);
        }
    }

    public int insert(int key){
        Node newNode = new Node(key);
        Node foundNode = searchHelper(root, key);

        if (foundNode == null){
            foundNode = foundNode.getParent();
        }

        if (foundNode.getValue() == key){
            rebalaceAccess(foundNode);
        }
        else {
            if (key < foundNode.getValue()){
                foundNode.setLeft(newNode);
            }
            else {
                foundNode.setRight(newNode);
            }

            newNode.setParent(foundNode);
            rebalaceInsert(newNode);
        }
        return key;
    }

    public int remove(int key){
        Node foundNode = searchHelper(root, key);

        if (foundNode.getValue() == key){
            return removeHelper(foundNode, key);
        }

        return key;
    }

    public int removeHelper(Node node, int key){
        Node successor = node;

        if (hasNoChild(node)){
            removeLeafNode(node, node.getValue());
        }

        if (hasOneChild(node)){
            replaceNodeWithChildNode(node);
        }

        if (hasTwoChild(node)){
            successor = getInorderSuccessor(node.getRight());
            node.setValue(successor.getValue());
            removeHelper(successor, successor.getValue());
        }

        rebalanceDelete(successor.getParent());
        return node.getValue();
    }

    private boolean hasNoChild(Node node){
        return node.getLeft() == null && node.getRight() == null;
    }

    private boolean hasOneChild(Node node){
        return node.getLeft() != null && node.getRight() == null || node.getLeft() == null && node.getRight() != null;
    }

    private boolean hasTwoChild(Node node){
        return node.getLeft() != null && node.getRight() != null;
    }

    private void removeLeafNode(Node node, int value){
        Node parentNode;

        if (node.getParent() != null){
            parentNode = node.getParent();
        }
        else {
            parentNode = node;
        }

        if (parentNode.getLeft() != node && parentNode.getLeft().getValue() == value){
            parentNode.setLeft(null);
        }
        else {
            parentNode.setRight(null);
        }
    }

    private void replaceNodeWithChildNode(Node node){
        Node child = (node.getLeft() != null ? node.getLeft() : node.getRight());

        if (child != null){
            child.setParent(node.getParent());
        }

        if (node == root){
            node = child;
        }
        else {
            Node parent = node.getParent();

            if (node == parent.getLeft()){
                parent.setLeft(child);
            }
            else {
                parent.setRight(child);
            }
        }
    }

    private Node getInorderSuccessor(Node node){
        while (node.getLeft() != null){
            node = node.getLeft();
        }

        return node;
    }

    public void rotate(Node node){
        Node x = node;
        Node y = x.getParent();
        Node z = y.getParent();

        if (z == null){
            root = x;
            x.setParent(null);
        }
        else {
            relink(z, x, y == z.getLeft());
        }

        if (x == y.getLeft()){
            relink(y, x.getRight(), true);
            relink(x, y, false);
        }
        else {
            relink(y, x.getLeft(), false);
            relink(x, y, true);
        }
    }

    public Node restructure(Node x){
        Node y = x.getParent();
        Node z = y.getParent();

        if ((x == y.getRight()) == (y == z.getRight())){
            rotate(y);
            return y;
        }
        else{
            rotate(x);
            rotate(x);
            return x;
        }
    }

    private void relink(Node parent, Node child, boolean makeLeftChild){
        if (child != null){
            child.setParent(parent);
        }

        if (makeLeftChild){
            parent.setLeft(child);
        }
        else {
            parent.setRight(child);
        }
    }

    public boolean isInternal(Node node){
        return hasOneChild(node) || hasTwoChild(node);
    }

    public void rebalaceAccess(Node node) {};
    public void rebalaceInsert(Node node) {};
    public void rebalanceDelete(Node node) {};

    public void inorder(Node node){
        if (node != null){
            inorder(node.getLeft());
            printNode(node);
            inorder(node.getRight());
        }
    }

    private void printNode(Node node) {
        if (node.getValue() == getRoot().getValue()) {
            System.out.print("Root Node: " + node.getValue());
        } else {
            System.out.print("Current Node: " + node.getValue());
        }

        printNodeInformation(node.getParent(), " Parent: ");
        printNodeInformation(node.getLeft(), " Left Child: ");
        printNodeInformation(node.getRight(), " Right Child: ");
        System.out.print(" Height Property: " + node.getHeight());

        System.out.println();
    }

    private void printNodeInformation(Node node, String string) {
        if (node != null) {
            System.out.print(string + node.getValue());
        }
    }
}
