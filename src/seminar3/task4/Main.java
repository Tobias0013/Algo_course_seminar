package seminar3.task4;

import seminar3.task1.BinaryHeap;
import seminar3.task4.AVLTree.AVLTree;
import seminar3.task4.BinaryTree.BinarySearchTree;
import seminar3.task4.RedBlackTree.RedBlackTree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //task4a_a();
        //task4a_b();
        //task4a_c();
        //task4a_d();
        testAVL();
    }

    public static void task4a_a(){
        System.out.println("----- task4a_a -----");

        Integer[] x = {6, 2, 8, 1, 4, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer i : x) {
            bst.insert(i);
        }
        bst.inorder(bst.getRoot());
        System.out.println();
    }

    public static void task4a_b(){
        System.out.println("----- task4a_b -----");

        Integer[] tmp = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};
        BinaryHeap bh = new BinaryHeap(tmp);
        bh.printInOrder();
        System.out.println();
    }

    public static void task4a_c(){
        System.out.println("----- task4a_c -----");

        Integer[] y = {6, 2, 8, 1, 4, 3};
        AVLTree<Integer> avl = new AVLTree<>();
        for (Integer i : y) {
            avl.insert(i);

        }
        avl.inorder(avl.getRoot());
        System.out.println();
    }

    public static void task4a_d(){
        System.out.println("----- task4a_d -----");

        Integer[] z = {85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55}; //14
        RedBlackTree rbt = new RedBlackTree(10);
        for (Integer i : z) {
            rbt.insert(i);
        }
        rbt.inorder(rbt.getRoot());
        System.out.println();
    }

    public static void testAVL(){

        System.out.println("DoubleLeft");
        Integer[] y = {6, 2, 8, 1, 4, 3};
        AVLTree<Integer> avl = new AVLTree<>();
        for (Integer i : y) {
            avl.insert(i);

        }
        avl.inorder(avl.getRoot());
        System.out.println();

        System.out.println("DoubleRight");
        Integer[] x = {6, 2, 10, 7, 15, 8};
        AVLTree<Integer> avl2 = new AVLTree<>();
        for (Integer i : x) {
            avl2.insert(i);

        }
        avl2.inorder(avl2.getRoot());
        System.out.println();

        System.out.println("SingleLeft");
        Integer[] z = {6, 2, 8, 1, 4, 0};
        AVLTree<Integer> avl3 = new AVLTree<>();
        for (Integer i : z) {
            avl3.insert(i);

        }
        avl3.inorder(avl3.getRoot());
        System.out.println();

        System.out.println("SingleRight");
        Integer[] a = {6, 2, 10, 7, 15, 20};
        AVLTree<Integer> avl4 = new AVLTree<>();
        for (Integer i : a) {
            avl4.insert(i);
        }
    }


}
