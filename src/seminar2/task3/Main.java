package seminar2.task3;

public class Main {
    public static void main(String[] args) {
        LinkedList<Contact> list = new LinkedList<>();

        list.add(new Contact("First", "First addr"));
        list.add(new Contact("Second", "Second addr"));
        list.add(new Contact("Third", "Third addr"));
        list.add(new Contact("Forth", "Forth addr"));
        list.add(new Contact("Fifth", "Fifth addr"));

        System.out.println(list);

        System.out.println(list.get(2));

        list.remove(4);
        list.remove(2);
        list.remove(0);

        System.out.println(list);
    }
}
