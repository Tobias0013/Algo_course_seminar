package seminar2.task4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class contains task 4.a "one using ArrayList with Iterator"
 */
public class JosephusListIterator {
    private ArrayList<String> list = new ArrayList<>();
    private int m;
    private Iterator<String> it;

    public JosephusListIterator(int n, int m) {
        this.m = m;
        createList(n);
        this.it = list.iterator();
    }

    public String runGame(){
        it.next();
        while (list.size() > 1) {
            runRound();
            nextIterator();
        }
        return list.get(0);
    }

    private void runRound(){
        for (int i = 0; i < m; i++) {
            nextIterator();
        }
        it.remove();
    }

    private void nextIterator(){
        if (it.hasNext()){
            it.next();
        }
        else {
            it = list.iterator();
            it.next();
        }
    }

    private void createList(int n){
        for (int i = 1; i < n+1; i++) {
            list.add("person " + i);
        }        
    }
}
