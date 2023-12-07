package seminar2.task4;

import java.util.Random;

public class TestRunningTime {

    public static void main(String[] args) {
        automatedAnalazys();
    }
    
    private static void automatedAnalazys(){
        int n = 100;
        int m;
        double[][] duration = new double[4][10];
        String[] names = {"arrayList", "arrayList with iterator",
                "own LinkedList", "LinkedList with iterator"};
        Random rnd = new Random();

        for (int i = 0; i < duration[0].length; i++) {
            m = rnd.nextInt(0, n);
            System.out.println("i now = " + i);

            for (int j = 0; j < duration.length; j++) {
                System.out.println("j now = " + j);
                duration[j][i] = analyze(j, n, m, 10);
            }
            n = n * 10;
        }

        System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", "Algorithm used",
                "100", "200", "300", "400", "500",
                "600", "700", "800", "900", "1 000");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < duration.length; i++) {
            System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s %n", names[i],
                    duration[i][0], duration[i][1], duration[i][2], duration[i][3], duration[i][4],
                    duration[i][5], duration[i][6], duration[i][7], duration[i][8], duration[i][9]);
        }
    }

    /**
     * @param mode 0 = List, 1 = ListIterator, <br>
     *             2 = LinkedList, 3 = LinkedListIterator
     */
    private static double analyze(int mode, int n, int m, int times){
        double sum = 0;
        for (int i = 0; i < times; i++) {
            long startTime = System.nanoTime();

            runAlgo(mode, n, m);

            long endTime = System.nanoTime();
            sum += (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds
        }
        return sum / times;
    }

    /**
     * @param mode 0 = List, 1 = ListIterator, <br>
     *             2 = LinkedList, 3 = LinkedListIterator
     */
    private static void runAlgo(int mode, int n, int m){
        switch (mode){
            case 0:
                JosephusList josephusList = new JosephusList(n, m);
                josephusList.runGame();
                break;
            case 1:
                JosephusListIterator josephusListIterator = new JosephusListIterator(n, m);
                josephusListIterator.runGame();
                break;
            case 2:
                JosephusLinkedList josephusLinkedList = new JosephusLinkedList(n, m);
                josephusLinkedList.runGame();
                break;
            case 3:
                JosephusLinkedListIterator josephusLinkedListIterator = new JosephusLinkedListIterator(n, m);
                josephusLinkedListIterator.runGame();
                break;
        }
    }

}
