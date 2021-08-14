package DataStructures.LinkedList;

class Stack {
   int top  = -1;
   int[] arr = new int[500];

   private boolean push(int value){
       if(top<500){
           top++;
           arr[top] = value;
           System.out.println("pushing value into stack = "+ value);
           return true;
       }else return false;
   }

   private int pop(){
       if(top>-1){
           int tmp = arr[top];
           top--;
           return tmp;
       }else return -1;
   }

   private int peek(){
       if(top>-1){
           int tmp = arr[top];
           return tmp;
       }else return -1;
   }

   private boolean isEmpty(){
       if(top==-1) return true;
       return false;
   }


    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(10);
        System.out.println("Peeking from stack" + stk.peek());
        System.out.println("poping from stack"+stk.pop());
        System.out.println("Peeking from stack" + stk.peek());
        while (!stk.isEmpty()){
            System.out.println("pop from stack"+stk.pop());
        }
        System.out.println("How many elements are present in stack now"+ stk.isEmpty());

    }

}


/*
1) push
2) pop
3)peek
4) isEmpty

arr[3]  = 10
arr[2] = 3
arr[1] = 2
arr[0] = 1


 */