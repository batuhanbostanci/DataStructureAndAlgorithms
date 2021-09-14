package PartA;

public class BinarySearchTree {

    private String data;
    private BinarySearchTree left;
    private BinarySearchTree right;
    public static int h =0;
    public static boolean isLeaf;
    public static int subtree;
    public static String leafNode;
    public static String a="";

    Node node;
    BinarySearchTree(){node=null;}

    String minValue(){
        return minValue(node);
    }
    // to find minValue
    String minValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
            break;
        }
        return (current.key);
    }

    String maxValue(){
        return maxValue(node);
    }
    //To find max value
    String maxValue(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return (current.key);
    }



    //Inserting method
    Node insertKey(Node node, String key){
        if(node==null){
            node = new Node(key);
            return  node;
        }
        int compare= key.compareTo(node.key);
        if(compare<0){
            node.left = insertKey(node.left,key);
        }else if(compare>0){
            node.right = insertKey(node.right,key);
        }
        return node;
    }
    //inserting and display part
    void insert(String key){
        node = insertKey(node,key);
    }
    void display(Node root) {

        if (root != null) {
            display(root.left);
            System.out.println( root.key );
            display(root.right);
        }
    }
    void display() {
        display(node);
        //  System.out.println();
    }
    int sizeOfTheSubtree(Node node)
    {
        if (node == null)
            return 0;
        else
            return(sizeOfTheSubtree(node.left) + 1 + sizeOfTheSubtree(node.right));
    }
    //this is getting name after searching
    String search(String name){
            search(node, name);
            int height1 = h - 1;
            h = 0;
            search(node, a);
            int height2 = h - 1;
            h = 0;
            int differences = height2 - height1;
            if (differences == 0) {
                isLeaf = true;
                if (isLeaf == true) {
                    leafNode = "Leaf Node";
                }
            } else {
                isLeaf = false;
                if (isLeaf == false) {
                    leafNode = "";
                }
            }
            return ("Depth of the: " + search(node, name) + " is " + (h - 1) + "\n" +
                    "Is Leaf Node: " + leafNode + "\n"
                    + "The size of the subtree where the name was found: " +subtree);
    }

    //This is for searching and h means that to calculate the depth of the index
    String search(Node node, String search){
        a= maxValue(node);
         subtree = sizeOfTheSubtree(node);
        if(search.compareTo(node.key)==0){
            h++;
            if(node.right==null&&node.left==null){
                isLeaf=true;
            }
            return node.key;
        }
        else if (search.compareTo(node.key)<0){
            h++;
            return search(node.left,search);
        }
        else
            h++;
        return search(node.right,search);
    }
}
class Node{
    Node left;
    Node right;
    String key;
    public Node(String data){
        key= data;
        this.left= null;
        this.right=null;
    }
}
