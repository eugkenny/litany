package litany.util;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> q = new LinkedQueue<>();

        q.enqueue("hello");
        q.enqueue("there");
        q.enqueue("welcome");
        q.enqueue("the class");

        for(String i : q){
            System.out.println(i);
        }

        System.out.println(q);
    }

}
