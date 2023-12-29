package seminar3.task3;

import java.util.ArrayList;
import java.util.List;

public class WordPuzzle {
    private List<String> foundWords = new ArrayList<>();
    private final char[][] puzzle = {{'t', 'h', 'i', 's'},
                                     {'w', 'a', 't', 's'},
                                     {'o', 'a', 'h', 'g'},
                                     {'f', 'g', 'd', 't'}};
    private final List<String> words = List.of(new String[]{"this", "two", "fat", "that"});

    public List<String> getFoundWords() {
        return foundWords;
    }

    public void calc(){
        for (int y = 0; y < puzzle.length; y++) {
            for (int x = 0; x < puzzle[y].length; x++) {
                charAlgo(x, y);
            }
        }
    }

    private void charAlgo(int x, int y){
        for(int dir = 0; dir < 9; dir++) {
            if (dir == 4) continue; // direction 4 is staying still, invalid.
            search(x, y, dir);
        }
    }

    /**
     * 0 = x--, y--, vänster neråt
     * 1 = x--,      vänster
     * 2 = x--, y++, vänster upp
     * 3 = y--,      upp
     * 5 = y++,      ner
     * 6 = x++, y--, upp höger
     * 7 = x++       höger
     * 8 = x++, y++, ner höger

     * @param x
     * @param y
     * @param dir
     */
    private void search(int x, int y, int dir){
        int ty = y, tx = x;

        String word = "" + puzzle[ty][tx];

        while(tx + ((dir / 3) - 1) >= 0 && tx + ((dir / 3) - 1) < puzzle[ty].length
                && ty + ((dir % 3) - 1) >= 0 &&  ty + ((dir % 3) - 1) < puzzle.length) {

            word += puzzle[ty += ((dir % 3) - 1)][tx += ((dir / 3) - 1)];

            for (String s : words) {
                if (s.equals(word)) {
                    foundWords.add(word);
                    return;
                }

                // TODO: 2023-12-27 refactor om ordet än så länge inte matchar ett känt ord
            }

        }
    }
}
