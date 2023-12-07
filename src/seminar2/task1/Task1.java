package seminar2.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task1 {

    public static String[] readFile(String strPath){
        Path path = Paths.get(strPath);
        try {
            return Files.readAllLines(path).toArray(new String[0]);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void subtaskA(String[] code){
        for (int i = 0; i < code.length; i++) {
            char[] openValues = {'[', '{'};
            char[] closeValues = {']', '}'};

            code[i] = checkForLineComment(code[i], "//");
            code[i] = checkForComment(code[i], "/*", "*/", i);

            for (int j = 0; j < openValues.length; j++) {
                checkOpenClosed(code[i], openValues[j], closeValues[j], i);
            }
        }
    }

    public static void subtaskB(String[] code){
        for (int i = 0; i < code.length; i++) {
            char[] openValues = {'(', '[', '{'};
            char[] closeValues = {')', ']', '}'};

            code[i] = checkForLineComment(code[i], "//");

            for (int j = 0; j < openValues.length; j++) {
                checkOpenClosed(code[i], openValues[j], closeValues[j], i);
            }
        }
    }

    private static void checkOpenClosed(String str, char open, char close, int line){
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (c == open)
                sum++;
            else if (c == close)
                sum--;

            if (sum < 0){
                System.out.printf("error on line: %d, unexpected token %s %n", line, close);
                return;
            }
        }

        if (sum > 0){
            System.out.printf("error on line: %d, token %s not closed %n", line, open);
        }
    }

    private static String checkForComment(String str, String open, String close, int line){
        int i, j;
        String temp;
        while (true){
            i = str.indexOf(open);
            j = str.indexOf(close);

            if (i == -1 && j == -1) {
                break;
            }

            if (i == -1){
                System.out.printf("error on line: %d, unexpected token */ %n", line);
                break;
            } else if (j == -1) {
                System.out.printf("error on line: %d, token /* not closed %n", line);
                str = checkForLineComment(str, open);
                break;
            } else if (i > j) {
                System.out.printf("error on line: %d, unexpected token */ %n", line);
                j += 2;
                str = String.copyValueOf(str.toCharArray(), j, str.length()-j);
            }
            else {
                j += 2;
                temp = String.copyValueOf(str.toCharArray(), 0, i);
                temp += String.copyValueOf(str.toCharArray(), j, str.length()-j);
                str = temp;
            }

        }

        return str;
    }

    private static String checkForLineComment(String str, String commentValue){
        int i = str.indexOf(commentValue);
        if (i == -1){ // if no line comment
            return str;
        }
        return String.copyValueOf(str.toCharArray(), 0, i);
    }
}
