package seminar2.task4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class contains task 4.a "one with ArrayList"
 */
public class JosephusList {
    private ArrayList<String> list = new ArrayList<>();
    private int n;
    private int m;
    private int current = 0;


    public JosephusList(int n, int m) {
        this.m = m;
        this.n = n;
        createList();
    }
    public String runGame(){
        while (list.size() > 1){
            runRound();
        }
        return list.get(0);
    }

    private void runRound(){
        current = (current + m) % list.size();
        list.remove(current);
    }

    private void createList(){
        for (int i = 1; i < n+1; i++) {
            list.add("person " + i);
        }
    }
}
