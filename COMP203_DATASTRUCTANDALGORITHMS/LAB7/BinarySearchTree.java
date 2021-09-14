import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    Node node;
    BinarySearchTree(){
            node=null;
        }
        //list list keep the values for examples of output
    List<Integer> lis = new LinkedList<Integer>();
//insert method
    void insert(int key) {
        lis.add(key);
        node = insertKey(node, key);
    }
//This is for the writing with sorting indexes
    void display() {
        for(int i=0;i<lis.size();i++){
            System.out.println(lis.get(i)+" inserted ");
        }
        System.out.print("Original tree:    ");
        display(node);
        System.out.println();
    }
    // This one get the indexes with an ordered way
    void display(Node root) {

        if (root != null) {
            display(root.left);
            System.out.print( root.key+"  " );
            display(root.right);
        }

    }
    //Searching index in BTS
    boolean search (int key)  {
        node = searchingInTree(node, key);
        if (node!= null) {
            System.out.println("Check whether node with value of " + key + ":  true" );
            return true;
        }
        else
            System.out.println("Check whether node with value of " + key + ":  false" );
            return false;
    }
    //This is also for the searching with recursive method
    //also, we make a search with this method above
    Node searchingInTree(Node root, int key)  {

        if (root==null || root.key==key)
            return root;

        if (root.key > key)
            return searchingInTree(root.left, key);

        return searchingInTree(root.right, key);
    }

        // This is insert method for the binary search tree
        //with this one we are gonna check a data which has already have or not if it is not. With
        // method names insert which is above of this method names insert
        //This method is recursive BTS method
    Node insertKey(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key)
            node.left = insertKey(node.left, key);
        else if (key > node.key)
            node.right = insertKey(node.right, key);

        return node;
    }


}
