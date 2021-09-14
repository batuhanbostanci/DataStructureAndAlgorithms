public class Question2<E> implements Stack<E> {
    // Firstly, I added new private int in bottom to control first index of stack after
    // that, if we add new int to the stack, the stack replace the new value to the first index and then
    // continue normal stack process
    public static void main(String[] args){
        Question2<Integer> stack = new Question2<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //stack.push(6);
        //stack.push(7);
        //stack.push(8);
        //stack.push(9);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

    /** Default array capacity. */
    public static final int CAPACITY=4;   // default array capacity

    /** Generic array used for storage of stack elements. */
    private E[] data;                        // generic array used for storage

    /** Index of the top element of the stack in the array. */
    private int t = -1;
    private int bottom =-1;// index of the top element in stack

    /** Constructs an empty stack using the default array capacity. */
    public Question2() { this(CAPACITY); }  // constructs stack with default capacity

    /**
     * Constructs and empty stack with the given array capacity.
     * @param capacity length of the underlying array
     */
    @SuppressWarnings({"unchecked"})
    public Question2(int capacity) {        // constructs stack with given capacity
        data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
    }

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    @Override
    public int size() { return (t + 1); }

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return (t == -1); }

    /**
     * Inserts an element at the top of the stack.
     * @param e   the element to be inserted
     * @throws IllegalStateException if the array storing the elements is full
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {

                data[++bottom]=e;

                if(bottom==3){
                    bottom=-1;
                }

        }else {
            data[++t] = e;
        }// increment t before storing new item
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;                        // dereference to help garbage collection
        t--;
        return answer;
    }

    /**
     * Produces a string representation of the contents of the stack.
     * (ordered from top to bottom). This exists for debugging purposes only.
     *
     * @return textual representation of the stack
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = t; j >= 0; j--) {
            sb.append(data[j]);
            if (j > 0) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

}
