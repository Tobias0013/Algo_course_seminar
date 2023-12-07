package seminar2.task4;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int m = 1;

        JosephusList josephusList = new JosephusList(n, m);
        String winner = josephusList.runGame();
        System.out.println("with ArrayList result: " + winner);

        JosephusListIterator josephusListIterator = new JosephusListIterator(n, m);
        String winner1 = josephusListIterator.runGame();
        System.out.println("with ArrayList using Iterator result: " + winner1);

        JosephusLinkedList josephusLinkedList = new JosephusLinkedList(n, m);
        String winner2 = josephusLinkedList.runGame();
        System.out.println("with my own LinkedList result: " + winner2);

        JosephusLinkedListIterator josephusLinkedListIterator = new JosephusLinkedListIterator(n, m);
        String winner3 = josephusLinkedListIterator.runGame();
        System.out.println("with LinkedList using Iterator result: " + winner3);

    }
}
