package PartB;

public class AVLTree<T extends Comparable<T>> {

    AVLNode<T> node;

    public AVLTree(){ node=null; }
    //this is for the height of the node
    int height(AVLNode<T> node){
        if(node==null){
            return 0;
        }
        return node.getHeight();
    }
    //to find max of 2 numbers
    int max(int a, int b){
        if(a>b){
            return a;
        }else {
            return b;
        }
    }

    //this is for the find the differences between left and right side
    int diff(AVLNode<T> node){
        if(node==null){
            return 0;
        }else {
            return height(node.getLeft())-height(node.getRight());
        }
    }
    //inserting method
    AVLNode<T> insert(T name){
        node = insert(node,name);
        return node;
    }
    //insert method for the inserting indexes
    AVLNode<T> insert(AVLNode<T> node, T name){
        if(node==null){
            return new AVLNode<T>(name);
        }
        if(node.getData().compareTo(name)<0){
            node = new AVLNode<T>(node.getData(),node.getLeft(),insert(node.getRight(),name));
        }else if(node.getData().compareTo(name)>0){
            node = new AVLNode<T>(node.getData(), insert(node.getLeft(),name),node.getRight());
        }
        node.height=max(height(node.getLeft()),height(node.getRight()))+1;
        int h= diff(node);
        if(h>1&&name.compareTo(node.left.getData())<0) {
            return rotateRight(node);
        }
        if(h<-1&& name.compareTo(node.right.getData())>0){
            return rotateLeft(node);
        }
        if(h>1&& name.compareTo(node.left.getData())>0){
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if(h<-1&& name.compareTo(node.right.getData())<0){
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        return  node;
    }
    AVLNode<T> delete(T name){
        node = delete(node,name);
        System.out.println(name + " is deleted ");
        return node;
    }
    //delete method for the deleting indexes
    AVLNode<T> delete(AVLNode<T> node, T name) {
        if (node == null) {
            return null;
        }
        if (name.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), name));
        } else if (name.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), name));
        }else{
            if(node.getLeft()==null||node.getRight()==null){
                AVLNode<T> temp;
                if(node.getLeft() !=null)
                    temp=node.getLeft();
                else
                    temp=node.getRight();

                if(temp==null){
                    temp=node;
                    node=null;
                }
                else
                    node=temp;
                temp=null;
            }else{
                AVLNode<T> temp =minOfSubNode(node.getRight());
                node.setData(temp.getData());
                node.setRight(delete(node.getRight(), temp.getData()));
            }
        }
        if(node==null)
            return node;

        node.height=max(height(node.getLeft()),height(node.getRight()))+1;
        int h= balncFactor(node);
        if(h>1&&name.compareTo(node.left.getData())<0) {
            return rotateRight(node);
        }
        if(h<-1&& name.compareTo(node.right.getData())>0){
            return rotateLeft(node);
        }
        if(h>1&& name.compareTo(node.left.getData())>0){
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if(h<-1&& name.compareTo(node.right.getData())<0){
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        return node;
    }
    //searching method for printing to the console
    boolean search(T name){

        if (search(node,name)==null){
            System.out.println("There is no index with this name!");
            return false;
        }else{
            System.out.println("Name of the searching data is " + name+"\n"+
                    "Depth is " + node.getHeight()+ "\n"+
                    "Height is " + diff(node));
            System.out.println("----");
            return true;
        }
    }
    //searching method
    AVLNode<T> search(AVLNode<T> node, T search){
        if(node==null){
            return null;
        }
        if(search.compareTo(node.getData())==0){
            return node;
        }
        else if (search.compareTo(node.getData())<0){
            return search(node.getLeft(),search);
        }
        else {
            return search(node.getRight(), search);
        }
    }
    //minimum of index of the tree method
    AVLNode<T> minOfSubNode(AVLNode<T> node){
        AVLNode<T> current = node;
        while (current.getLeft() !=null)
            current=current.getLeft();
        return current;
    }
    //is the tree balance or not method
    int balncFactor(AVLNode<T> node){
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getLeft());
        if(leftHeight-rightHeight>=2){
            return -1;
        }else if(leftHeight-rightHeight<=-2){
            return 1;
        }
        return 0;
    }
    //avl tree rotation left side
    AVLNode<T> rotateLeft(AVLNode<T> node){
        AVLNode<T> rotationOfNode = node.getRight();
        AVLNode<T> tempRotationOfNode = rotationOfNode.getLeft();

        rotationOfNode.setLeft(node);
        node.setRight(tempRotationOfNode);

        node.height=max(height(node.getLeft()),height(node.getRight()))+1;
        rotationOfNode.setHeight(max(height(rotationOfNode.getLeft()),height(rotationOfNode.getRight()))+1);
        return rotationOfNode;
    }
    //avl tree rotation right side
    AVLNode<T> rotateRight(AVLNode<T> node){
        AVLNode<T> rotationOfNode = node.getLeft();
        AVLNode<T> tempRotationOfNode = rotationOfNode.getRight();

        rotationOfNode.setRight(node);
        node.setLeft(tempRotationOfNode);

        node.setHeight(max(height(node.getLeft()),height(node.getRight()))+1);
        rotationOfNode.setHeight(max(height(rotationOfNode.getLeft()),height(rotationOfNode.getRight()))+1);
        return rotationOfNode;
    }
    //This is for the display the data
    void display(AVLNode<T> node) {

        if (node != null) {
            display(node.left);
            System.out.println("Data is "+ node.getData() + "\n"+
                    "Depth is " + node.getHeight()+ "\n"+
                    "Height is " + diff(node));
            System.out.println("----");
            display(node.right);
        }
    }
    void display() {
        display(node);
        //  System.out.println();
    }
}
