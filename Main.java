import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Main
{

    public static void main(String[] args)
    {
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        Node root = new Node(Integer.toString(rand_int));

        int total_nodes = rand.nextInt(100);
        int total_current = 1;
        while(total_current < 10){
            rand_int = rand.nextInt(100);
            Node new_node = new Node(Integer.toString(rand_int));
            root.AddNodeToLeaf(new_node);

            ++total_current;
        }

        System.out.println("There are " + root.CountNodes() + " nodes in this tree from Node\n" + root.toString());
        System.out.println("There are " + root.CountLeafs() + " leaves in this tree from Node\n" + root.toString());


        System.out.println("\n=== Recursive in-order ===");
        root.PrintTree();

        System.out.println("\n=== Iterative breadth-first ===");
        root.PrintTreeQueue();

        System.out.println("\n=== Iterative depth-first ===");
        root.PrintTreeStack();
    }


}