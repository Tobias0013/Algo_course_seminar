package seminar2.task4;

import java.util.Random;

public class TestRunningTime {

    public static void main(String[] args) {
        System.out.println("Start automatedAnalazys1");
        System.out.println();
        automatedAnalazys();
        System.out.println("End automatedAnalazys1");
        System.out.println("Start automatedAnalazys2");
        System.out.println();
        automatedAnalazys2();
        System.out.println("End automatedAnalazys1");
    }
    
    private static void automatedAnalazys(){
        int inputSize = 100_000;
        int n;
        int m = 1000;
        AnalyzeThread[][] duration = new AnalyzeThread[4][10];
        Thread[][] threads = new Thread[4][10];
        String[] names = {"arrayList", "arrayList with iterator",
                "own LinkedList", "LinkedList with iterator"};


        for (int i = 0; i < duration[0].length; i++) {
            n = inputSize * (i + 1);
            for (int j = 0; j < duration.length; j++) {
                duration[j][i] = new AnalyzeThread(j, m, n, 10);

                threads[j][i] = new Thread(duration[j][i]);
                threads[j][i].start();
            }
        }

        for (int i = 0; i < threads.length; i++) {
            for (int j = 0; j < threads[0].length; j++) {
                try {
                    threads[i][j].join();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
        System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s |%25s %n", "Algorithm used",
                inputSize * 1, inputSize * 2, inputSize * 3, inputSize * 4, inputSize * 5,
                inputSize * 6, inputSize * 7, inputSize * 8, inputSize * 9, inputSize * 10);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < duration.length; i++) {
            System.out.printf("%25s |%25.3f |%25.3f |%25.3f |%25.3f |%25.3f |%25.3f |%25.3f |%25.3f |%25.3f |%25.3f %n", names[i],
                    duration[i][0].getAvgTime(), duration[i][1].getAvgTime(), duration[i][2].getAvgTime(), duration[i][3].getAvgTime(), duration[i][4].getAvgTime(),
                    duration[i][5].getAvgTime(), duration[i][6].getAvgTime(), duration[i][7].getAvgTime(), duration[i][8].getAvgTime(), duration[i][9].getAvgTime());
        }

    }

    private static void automatedAnalazys2(){
        int n = 100;
        int m = 1000;
        AnalyzeThread[][] duration = new AnalyzeThread[4][5];
        Thread[][] threads = new Thread[4][5];
        String[] names = {"arrayList", "arrayList with iterator",
                "own LinkedList", "LinkedList with iterator"};


        for (int i = 0; i < duration[0].length; i++) {
            for (int j = 0; j < duration.length; j++) {
                duration[j][i] = new AnalyzeThread(j, m, n, 10);

                threads[j][i] = new Thread(duration[j][i]);
                threads[j][i].start();
            }
            n = n * 10;
        }

        for (int i = 0; i < threads.length; i++) {
            for (int j = 0; j < threads[0].length; j++) {
                try {
                    threads[i][j].join();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.printf("%25s |%25s |%25s |%25s |%25s |%25s %n", "Algorithm used",
                "100", "1 000", "10 000", "100 000", "1 000 000");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < duration.length; i++) {
            System.out.printf("%25s |%25.3f |%25.3f |%25.3f |%25.3f |%25.3f %n", names[i],
                    duration[i][0].getAvgTime(), duration[i][1].getAvgTime(), duration[i][2].getAvgTime(), duration[i][3].getAvgTime(), duration[i][4].getAvgTime());
        }

    }
}
