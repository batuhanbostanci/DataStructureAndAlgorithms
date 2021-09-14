package PartB;

public class AVLNode<T extends Comparable<T>> implements Comparable<AVLNode<T>>{
    public T data;
    public int level;
    public int height;
    public AVLNode<T> left;
    public AVLNode<T> right;
    //second Constructor for the AVLNode
    public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        if(right==null&&left==null){
            setHeight(1);
        }else if(right==null) {
            setHeight(left.getHeight()+1);
        }else if(left==null){
            setHeight(right.getHeight()+1);
        }else{
            if(right.getHeight()>left.getHeight()){
                setHeight(right.getHeight()+1);
            }else{
                setHeight(left.getHeight()+1);
            }
        }
    }
    //Constructor for the AVLNode
    public AVLNode(T data) {
        this.data = data;
        left =null;
        right=null;
    }

    //override method for the compare to
    @Override
    public int compareTo(AVLNode<T> o) {
        return 0;
    }
    //those are the getter and setter methods
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }


}
