import java.util.LinkedList;
import java.util.Stack;

public class Node {
    private Node leftChild;
    private Node rightChild;
    private String value;

    private Node parent = null;

    public Node(String valueArg) {
        this.value = valueArg;
    }

    public String getValue() { return this.value; }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setParent(Node parentArg) {
        this.parent = parentArg;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
        this.leftChild.setParent(this);
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
        this.rightChild.setParent(this);
    }

    public String toString() {
        String returnString = "Value: ";
        returnString += this.value;
        returnString += "\nChildren: "+ (null != this.leftChild ? this.leftChild.getValue() : "NULL") + ", "+ (null != this.rightChild ? this.rightChild.getValue() : "NULL");
        return returnString;
    }

    public boolean hasLeft() {
        return (leftChild != null);
    }

    public boolean hasRight() {
        return (rightChild != null);
    }



    public int CountNodes()
    {
        int count = 1;

        if(this.leftChild != null) count += this.leftChild.CountNodes();
        if(this.rightChild != null) count += this.rightChild.CountNodes();

        return count;
    }

    public int CountLeafs()
    {

        if(this.leftChild == null && this.rightChild == null) return 1;

        int count = 0;

        if(this.leftChild != null) count += this.leftChild.CountLeafs();
        if(this.rightChild != null) count += this.rightChild.CountLeafs();

        return count;
    }

    public void AddNodeToLeaf(Node new_node)
    {

        int value_parent = Integer.parseInt(this.value);
        int value_child = Integer.parseInt(new_node.getValue());
        if(value_child < value_parent)
        {
            if(this.leftChild == null){
                this.leftChild = new_node;
                return;
            }
            this.leftChild.AddNodeToLeaf(new_node);

        }
        else
        {
            if(this.rightChild == null)
            {
                this.rightChild = new_node;
                return;
            }
            this.rightChild.AddNodeToLeaf(new_node);

        }
    }




    public void PrintTree()
    {
        if(this.leftChild != null) this.leftChild.PrintTree();

        System.out.println(this.toString() + "\n");

        if(this.rightChild != null) this.rightChild.PrintTree();
    }

    public void PrintTreeQueue()
    {
        LinkedList<Node> queue = new LinkedList<>();
        Node current_node = this;
        queue.add(current_node);

        while(!queue.isEmpty()){
            current_node = queue.getFirst();
            if(current_node.hasLeft()) queue.add(current_node.getLeftChild());
            if(current_node.hasRight()) queue.add(current_node.getRightChild());

            System.out.println(current_node.toString() + "\n");
            queue.removeFirst();
        }
    }

    public void PrintTreeStack()
    {
        Stack<Node> stack = new Stack<>();
        Node current_node = this;
        stack.add(current_node);

        while(!stack.isEmpty()){
            current_node = stack.pop();

            if(current_node.hasRight()) stack.push(current_node.getRightChild());
            if(current_node.hasLeft()) stack.push(current_node.getLeftChild());

            System.out.println(current_node.toString() + "\n");
        }
    }

}