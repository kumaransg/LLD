package DataStructures.LinkedList;

public class Queue {
    int[] arr = new int[100];
    int front=0,rear=0;

    private void enqueue(int val){

        if(rear==arr.length-1){
            System.out.println("queue is full");
            return;
        }
        arr[rear]=val;
        rear++;
    }


    private int dequeue(){
        if(rear<0) {
            System.out.println("queue is empty");
            return -1;
        }
        int tmp  = arr[front];
        for(int i=1;i<rear;i++){
            arr[i-1]=arr[i];
        }
        rear--;
        return tmp;
    }

    private int frontElement(){
        if(rear<0) {
            System.out.println("queue is empty");
            return -1;
        }
        return arr[front];
    }

    private void printQueue(){
        for(int i=0;i<rear;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Queue a = new Queue();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.dequeue();
        a.dequeue();
        System.out.println("front element is: "+a.frontElement());
        a.printQueue();
    }

}

/*
4 3 2 1
|      |
rear   front

1  2    3   4   0
|          |
front    rear
 */