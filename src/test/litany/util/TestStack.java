package litany.util;

public class TestStack {
    public static void main(String[] args) {

        Stack<Integer> s = new LinkedStack<>();
        //ArrayStack<String> s1 = new ArrayStack<>()

        s.push(10);
        s.push(20);
        s.push(30);

        //System.out.println(s.pop());

        for(Integer i : s){
            System.out.println(i);
        }

        System.out.println(s);
    }
}
