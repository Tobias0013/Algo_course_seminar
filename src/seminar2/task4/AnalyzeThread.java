package seminar2.task4;

public class AnalyzeThread implements Runnable{
    private int mode;
    private int m;
    private int n;
    private int times;
    private double avgTime = 0;

    public AnalyzeThread(int mode, int m, int n, int times) {
        this.mode = mode;
        this.m = m;
        this.n = n;
        this.times = times;
    }

    public double getAvgTime() {
        return avgTime;
    }

    @Override
    public void run() {
        //System.out.println("Thread Start mode=" + mode + " , n=" + n);
        analyze(mode, n, m, times);
        //System.out.println("Thread End mode=" + mode + " , n=" + n);
    }

    /**
     * @param mode 0 = List, 1 = ListIterator, <br>
     *             2 = LinkedList, 3 = LinkedListIterator
     */
    private void analyze(int mode, int n, int m, int times){
        double tmpSum;

        for (int i = 0; i < times; i++) {
            long startTime = System.nanoTime();

            runAlgo(mode, n, m);

            long endTime = System.nanoTime();
            avgTime += (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds
        }
        avgTime =  avgTime / times;
    }

    /**
     * @param mode 0 = List, 1 = ListIterator, <br>
     *             2 = LinkedList, 3 = LinkedListIterator
     */
    private void runAlgo(int mode, int n, int m){
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

    @Override
    public String toString() {
        return Double.toString(avgTime);
    }
}
