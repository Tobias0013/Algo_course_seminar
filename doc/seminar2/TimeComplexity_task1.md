# Time complexity of Task 1

## readFile()

    public static String[] readFile(String strPath){
        Path path = Paths.get(strPath);                              //O(1)
        try {
            return Files.readAllLines(path).toArray(new String[0]);  //O(1)
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

All operations of this method has a time complexity of O(1)

Worst case time complexity is O(1)

---

## checkOpenClosed()

    private static void checkOpenClosed(String str, char open, char close, int line){
        int sum = 0;                          //O(1)
        for (char c : str.toCharArray()) {    //O(n)
            if (c == open)                    //O(1)
                sum++;
            else if (c == close)              //O(1)
                sum--;

            if (sum < 0){                     //O(1)
                System.out.printf();
                return;
            }
        }

        if (sum > 0){                         //O(1)
            System.out.printf();
        }
    }

This method has a loop that loops through the string char by char there for the loop runs O(n).
All other operations of this method has a time complexity of O(1)

Worst case time complexity is O(n)

---

## checkForComment()

    private static String checkForComment(String str, String open, String close, int line){
        int i, j;                                                                 //O(1)
        String temp;                                                              //O(1)
        while (true){                                                             //O(n/2)
            i = str.indexOf(open);                                                //O(1)
            j = str.indexOf(close);                                               //O(1)

            if (i == -1 && j == -1) {
                break;
            }

            if (i == -1){                                                         //O(1)
                System.out.printf();
                break;
            } else if (j == -1) {                                                 //O(1)
                System.out.printf();
                str = checkForLineComment(str, open);
                break;
            } else if (i > j) {                                                   //O(1)
                System.out.printf();
                j += 2;
                str = String.copyValueOf(str.toCharArray(), j, str.length()-j);   //O(1)
            }
            else {                                                                //O(1)
                j += 2;
                temp = String.copyValueOf(str.toCharArray(), 0, i);
                temp += String.copyValueOf(str.toCharArray(), j, str.length()-j); //O(1)
                str = temp;
            }

        }

This method has a loop. In this loop the code looks for a string match of /* or */. 
Since these strings contain two characters the worst case for this loop is O(n/2)
All other operations of this method has a time complexity of O(1)

Since we don't care about constants the complexity becomes O(n/2) => O(n)

Worst case time complexity is O(n)

---

## checkForLineComment()

    private static String checkForLineComment(String str, String commentValue){
        int i = str.indexOf(commentValue);                   //O(1)
        if (i == -1){ // if no line comment                  //O(1)
            return str;
        }
        return String.copyValueOf(str.toCharArray(), 0, i);  //O(1)
    }

All operations of this method has a time complexity of O(1)

Worst case time complexity is O(1)

---

## subtaskA()

    public static void subtaskA(String[] code){
        for (int i = 0; i < code.length; i++) {                               //O(n)
            char[] openValues = {'[', '{'};                                   //O(1)
            char[] closeValues = {']', '}'};                                  //O(1)

            code[i] = checkForLineComment(code[i], "//");                     //O(1)
            code[i] = checkForComment(code[i], "/*", "*/", i);                //O(1)

            for (int j = 0; j < openValues.length; j++) {                     //O(2)
                checkOpenClosed(code[i], openValues[j], closeValues[j], i);  
            }
        }
    }

The method has a loop. The loop loops through the string array. The loop has a time complexity of O(n)
All other operations of this method has a time complexity of O(1). Since O(2) => O(1) 

Worst case time complexity is O(n)

---

## checkForLineComment()

    public static void subtaskB(String[] code){
        for (int i = 0; i < code.length; i++) {                               //O(n)
            char[] openValues = {'(', '[', '{'};                              //O(1)
            char[] closeValues = {')', ']', '}'};                             //O(1)

            code[i] = checkForLineComment(code[i], "//");                     //O(1)

            for (int j = 0; j < openValues.length; j++) {                     //O(3)
                checkOpenClosed(code[i], openValues[j], closeValues[j], i);
            }
        }
    }

The method has a loop. The loop loops through the string array. The loop has a time complexity of O(n)
All other operations of this method has a time complexity of O(1). Since O(3) => O(1)

Worst case time complexity is O(n)

















