package seminar2.task1;

import static seminar2.task1.Task1.*;

public class Main {
    public static void main(String[] args) {
        testTaskA();
        testTaskB();
    }

    /**
     * This method test the “balance checking program” for task1.A
     * with the examples from Seminar2_2023.pdf
     */
    public static void testTaskA(){
        System.out.println("----------Task 1----------");
        System.out.println("----------Valid example----------");
        subtaskA(readFile("C:\\Users\\tv-dr\\IdeaProjects\\Algo_course_seminar\\src\\seminar2\\task1\\files\\task1aValid.txt"));
        System.out.println("----------not valid example----------");
        subtaskA(readFile("C:\\Users\\tv-dr\\IdeaProjects\\Algo_course_seminar\\src\\seminar2\\task1\\files\\task1aNotValid.txt"));
        System.out.println("--------------------------");
        System.out.println();
    }

    /**
     * This method test the “balance checking program” for task1.B
     * with the examples from Seminar2_2023.pdf
     */
    public static void testTaskB(){
        System.out.println("----------Task 2----------");
        System.out.println("----------Valid example----------");
        subtaskB(readFile("C:\\Users\\tv-dr\\IdeaProjects\\Algo_course_seminar\\src\\seminar2\\task1\\files\\task2bValid.txt"));
        System.out.println("----------not valid example----------");
        subtaskB(readFile("C:\\Users\\tv-dr\\IdeaProjects\\Algo_course_seminar\\src\\seminar2\\task1\\files\\task1bNotValid.txt"));
        System.out.println("--------------------------");
        System.out.println();
    }
}
