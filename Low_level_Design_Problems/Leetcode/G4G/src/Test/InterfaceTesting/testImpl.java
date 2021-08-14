package Test.InterfaceTesting;

public class testImpl extends AbstractTest{

    final int value = 20;

    public testImpl() {
        super();
    }

    public void print() {
        System.out.println("Geek");
        System.out.println(value);
        System.out.println();
//        Itest.value=15;
//        AbstractTest.value=16;
        System.out.println(Itest.value);
    }
    public static void main (String[] args)
    {
        testImpl t = new testImpl();
        t.print();
    }
}
