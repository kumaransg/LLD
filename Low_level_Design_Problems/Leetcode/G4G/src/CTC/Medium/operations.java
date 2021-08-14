package CTC.Medium;

public class operations {
    int negate(int a) {
        int neg= 0;
        int newSign = a < 0? 1 : -1;
        while (a!= 0) {
            neg+= newSign;
            a += newSign;
        }
        return neg;
        }

    int minus(int a, int b) {
        return a+ negate(b);
    }
    int multiply(int a, int b){
        if(a<b)
            return multiply(a,b);

        int sum=0;
        for(int i = abs(b); i>0; i= minus(i,1)){
            sum+=a;
        }
        if(b<0){
            sum=negate(sum);
        }
        return sum;
    }

    int abs(int b){
        if(b<0)
            return negate(b);

        return b;

    }

    int divide(int a, int b){
        if(b==0)
            throw new java.lang.ArithmeticException();

        int absA=abs(a);
        int absb=abs(b);
        int product =0;
        int x=0;
        while(product+absb<=absA){
            product+=absb;
            x++;
        }

        if((a<0 && b<0)|| (a>0 && b>0))
            return x;
        return negate(x);

    }
    public static void main(String args[]){
        operations o = new operations();
        int a = o.minus(4,2);
        System.out.println("4-2 :" + a);

        int c = o.multiply(5,5);
        System.out.println("5*5 :" + c);

        int d = o.divide(10,2);
        System.out.println("-10/2 :" + d);
    }
}
