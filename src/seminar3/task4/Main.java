package seminar3.task4;

import seminar3.task4.RedBlackTreeOld.RedBlackTree;

public class Main {
    public static void main(String[] args) {
        /*
        Integer[] x = {6, 2, 8, 1, 4, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer i : x) {
            bst.insert(i);
        }
        bst.printTree();
        System.out.println();

        Integer[] y = {6, 2, 8, 1, 4, 3};
        AVLTree<Integer> avl = new AVLTree<>();
        for (Integer i : y) {
            avl.insert(i);
        }
        avl.printTree();
        System.out.println();
         */

        Integer[] z = {10, 85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55}; //14
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        for (Integer i : z) {
            rbt.insert(i);
        }
        rbt.printTree();
        System.out.println();

        /*

        BookRBT<Integer> brbt = new BookRBT<>();
        for (Integer i : z) {
            brbt.insert(i);
        }
        brbt.printTree();
        System.out.println();

         */

    }
}
