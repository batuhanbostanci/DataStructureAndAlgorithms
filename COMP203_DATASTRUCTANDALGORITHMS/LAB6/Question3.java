public class Question3 {

    public static void main(String[]args){
            ArrayStack<Integer> stack1 = new ArrayStack<>();
            ArrayStack<Integer> stack2 = new ArrayStack<>();
          for(int i=1;i<=3;i++){
              stack1.push(i);
          }
          transferMethod(stack1,stack2);
          while (!stack2.isEmpty()){
              System.out.println(stack2.pop());
          }
    }
    public static void transferMethod(ArrayStack<Integer> S, ArrayStack<Integer>T){
        int number;
                    //transfer stack1 to stack2 
                    while(!S.isEmpty()){
                        number= S.pop();
                        T.push(number);
                    }
    }
}
