import Lista.LinkedList;

public class Main {
    public static void main(String[] args) {

        var list = new LinkedList<Integer>();

        for(int i = 0; i < 100; i++) list.add(i);

        for(var element : list) System.out.println(element);
    }
}