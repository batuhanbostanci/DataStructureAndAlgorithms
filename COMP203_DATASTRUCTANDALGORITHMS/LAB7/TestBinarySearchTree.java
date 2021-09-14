public class TestBinarySearchTree {
    public static void main(String[]args){
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.insert(20);
        tree.insert(25);
        tree.insert(15);
        tree.insert(16);
       
        tree.display();
        tree.search(15);


    }
}
