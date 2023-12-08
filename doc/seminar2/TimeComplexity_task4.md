# Time complexity Task 4

## using LinkedList

    public class JosephusLinkedList {
        private LinkedList<String> list = new LinkedList<>();
        private int n;
        private int m;
        private int current = 0;
    
        public JosephusLinkedList(int n, int m) {
            this.m = m;                             //O(1)
            this.n = n;                             //O(1)
            createList();                           //O(x)
        }
    
        public String runGame(){
            while (list.size() > 1){                //O(n)
                runRound();                         //O(1)
            }
            return list.get(0);                     //O(1)
        }
    
        private void runRound(){
            current = (current + m) % list.size();  //O(1)
            list.remove(current);                   //O(1)
        }
    
        private void createList(){
            for (int i = 1; i < n+1; i++) {         //O(x)
                list.add("person " + i);            //O(1)
            }
        }
    }

Constructors time complexity is T(x) = O(x)

runGame() has a worst case time complexity of O(n)

---

## using LinkedList with iterator

    public class JosephusLinkedListIterator {
        private LinkedList<String> list = new LinkedList<>();
        private int m;
        private Iterator<String> it;

        public JosephusLinkedListIterator(int n, int m) {
            this.m = m;                             //O(1)
            createList(n);                          //O(x)
            this.it = list.iterator();              //O(1)
        }
    
        public String runGame(){
            it.next();                              //O(1)
            while (list.size() > 1) {               //O(n)
                runRound();                         //O(1)
                nextIterator();                     //O(1)
            }
            return list.get(0);                     //O(1)
        }
    
        private void runRound(){
            for (int i = 0; i < m; i++) {           //O(m)
                nextIterator();                     //O(1)
            }
            it.remove();                            //O(1)
        }
    
        private void nextIterator(){
            if (it.hasNext()){                      //O(1)
                it.next();
            }
            else {                                  //O(1)
                it = list.iterator();
                it.next();
            }
        }
    
        private void createList(int n){
            for (int i = 1; i < n+1; i++) {         //O(x)
                list.add("person " + i);            //O(1)
            }
        }
    }

Constructors time complexity is T(x) = O(x)

runGame() has a worst case time complexity of T(n, m) = O(n * m)

If you view m as a constant the time complexity is T(n) = O(n)

---

## using ArrayList

    public class JosephusList {
        private ArrayList<String> list = new ArrayList<>();
        private int n;
        private int m;
        private int current = 0;
    
        public JosephusList(int n, int m) {
            this.m = m;                             //O(1)
            this.n = n;                             //O(1)
            createList();                           //O(x)
        }

        public String runGame(){
            while (list.size() > 1){                //O(n)
                runRound();                         //O(1)
            }
            return list.get(0);                     //O(1)
        }
    
        private void runRound(){
            current = (current + m) % list.size();  //O(1)
            list.remove(current);                   //O(1)
        }
    
        private void createList(){
            for (int i = 1; i < n+1; i++) {         //O(x)
                list.add("person " + i);            //O(1)
            }
        }
    }

Constructors time complexity is T(x) = O(x)

runGame() has a worst case time complexity of O(n)

---

## using ArrayList with iterator

    public class JosephusListIterator {
        private ArrayList<String> list = new ArrayList<>();
        private int m;
        private Iterator<String> it;
    
        public JosephusListIterator(int n, int m) {
            this.m = m;                             //O(1)
            createList(n);                          //O(x)
            this.it = list.iterator();              //O(1)
        }
    
        public String runGame(){
            it.next();                              //O(1)
            while (list.size() > 1) {               //O(n)
                runRound();                         //O(1)
                nextIterator();                     //O(1)
            }
            return list.get(0);                     //O(1)
        }
    
        private void runRound(){
            for (int i = 0; i < m; i++) {           //O(m)
                nextIterator();                     //O(1)
            }
            it.remove();                            //O(1)
        }
    
        private void nextIterator(){
            if (it.hasNext()){                      //O(1)
                it.next();
            }
            else {                                  //O(1)
                it = list.iterator();
                it.next();
            }
        }
    
        private void createList(int n){
            for (int i = 1; i < n+1; i++) {         //O(x)
                list.add("person " + i);            //O(1)
            }        
        }
    }

Constructors time complexity is T(x) = O(x)

runGame() has a worst case time complexity of T(n, m) = O(n * m)

If you view m as a constant the time complexity is T(n) = O(n)

