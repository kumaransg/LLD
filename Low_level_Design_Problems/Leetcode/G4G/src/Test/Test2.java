package Test;

class Test2 {

    public static void print(){
        System.out.println("I am in class2");
    }
}


class Test3{
    void print2(){
        Test2 t2 = null;
        t2.print();
    }

    public static void main(String args[]){
        Test3 t3 = new Test3();
        t3.print2();

        String name1 = "Ajay";
        String name2 = "Ajay";
        String name3 = new String("Ajay");
        System.out.println(name1==name2);
        System.out.println(name1.equals(name2));
        System.out.println(name1==name3);
        System.out.println(name1.equals(name3));

        Test3 t3_2 = new Test3();
        Test3 t3_3 = new Test3();
        t3_2 = null;
        t3_3 = null;
        System.gc();

        try{
            int x=1/0;
        }
        catch(Exception e){
            System.out.println(e);
            //System.exit(1);
        }
        finally{
            System.out.println("finally block is executed");
        }
        Integer a = 1;



    }
    public void finalize(){System.out.println("finalize called");}

}


