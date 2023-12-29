package seminar3.task2;

import javax.sound.sampled.Line;

public class Main {
    public static void main(String[] args) {
        //task2a();
        //task2b();
        //task2c();
        task2e();
        System.exit(0);
        System.out.println("\n\n\n");
        System.out.println("----- Test -----");
        Integer[] input = {89, 18, 49, 58, 69};
        LinearProbingHashTable hashTable1 = new LinearProbingHashTable();
        SeparateChainingHashTable hashTable2 = new SeparateChainingHashTable();
        QuadraticProbingHashTable hashTable3 = new QuadraticProbingHashTable();
        for (Integer i : input) {
            hashTable1.insert(i);
            hashTable2.insert(i);
            hashTable3.insert(i);
        }
        System.out.println(hashTable1);
        System.out.println(hashTable2);
        System.out.println(hashTable3);

        hashTable3.reHash();

        System.out.println(hashTable3);


    }

    public static void task2a(){
        System.out.println("----- Task2.a -----");

        Integer[] input =  {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        SeparateChainingHashTable hashTable = new SeparateChainingHashTable();

        for (Integer i : input) {
            hashTable.insert(i);
        }

        System.out.println(hashTable);

    }

    public static void task2b(){
        System.out.println("----- Task2.b -----");

        Integer[] input =  {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        LinearProbingHashTable hashTable = new LinearProbingHashTable();

        for (Integer i : input) {
            hashTable.insert(i);
        }

        System.out.println(hashTable);
    }

    public static void task2c(){
        System.out.println("----- Task2.c -----");

        Integer[] input =  {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable();

        for (Integer i : input) {
            hashTable.insert(i);
        }

        System.out.println(hashTable);

    }

    public static void task2e(){
        System.out.println("----- Task2.e -----");

        Integer[] input =  {4371, 1323, 6173, 4199, 4344, 9679, 1989};

        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable();

        for (Integer i : input) {
            hashTable.insert(i);
        }

        System.out.println(hashTable);

        hashTable.reHash();

        System.out.println(hashTable);
    }
}



















