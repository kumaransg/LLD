package CTC.Medium;

public class factorialZeroes {

    static int factorial(int number){
        if(number==1)
            return 1;
        int x = number * factorial(number-1);
        return x;

    }
    public static void main(String args[]){

//        int n = factorial(25);
//        System.out.println(n);

//        int carry=0;
//        while(n%10==0){
//            carry++;
//            n=n/10;
//        }
//        System.out.println(carry);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //////// OR ////////
        int count=0;
        int n =125;
        for(int i=5;n/i>0;i*=5){
            count+=n/i;
        }
        System.out.println(count);


    }
}
