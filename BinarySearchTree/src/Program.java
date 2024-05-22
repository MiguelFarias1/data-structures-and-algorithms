import java.util.Random;

import implementations.BinarySearchTree;

public class Program {

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for(int i = 0; i < 10; i++) tree.add(new Random().nextInt(0,800));

        if(tree.getSize() == 10) System.out.println("Deu certo!");

        for (var element : tree) {
            System.out.println(element);
        }

        
    }
}