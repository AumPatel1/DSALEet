import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        scanner.close();
    }
}

class BinaryTree{
    public BinaryTree(){}
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }

    }
    private Node root;
//commit and push




    public void populate(Scanner scanner){
        System.out.println("enter the root node");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner,root);
    }
    public void populate(Scanner scanner, Node node){
        System.out.println("do you want to enter in left of "+ node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("enter the value you want to enter on "+node.value);
            int val = scanner.nextInt();
            node.left = new Node(val);

            populate(scanner,node.left);
        }
        System.out.println("do you want to enter in right of "+ node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("enter the value you want to enter on "+node.value);
            int val = scanner.nextInt();
            node.right = new Node(val);

            populate(scanner,node.right);
        }
    }

    public void display(){
        display(this.root,"");
    }

    private void display(Node node , String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + root.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node , int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i =0 ;i<level-1;i++){
                System.out.println("|------>"+node.value);
            }
        }
    }

}