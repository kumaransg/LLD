package Test;

public class Altimetriktest {
    public static void main(String[] args){
        Altimetrik a = new Altimetrik();
        a.i=1;
        a.setName("Ajay");
        String n = a.getName();
        n ="Goel";
        System.out.println(n);
        System.out.println(a.name);
        Altimetrik b = new Altimetrik();
        b.i=1;
        b.setName("Ajay");
        a=b;


    }
}
