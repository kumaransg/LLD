package Array.Interface;

interface one{
    public void print_geek();
}
interface two{
    public void print_for();
}
interface three extends one,two{
    public void print_geek2();
}

abstract class four implements three{
    four(){

    }
    abstract void print_geek3();

    void print_geek4() {

    }
}
public class child extends four{
    @Override
    public void print_geek() {

    }

    @Override
    public void print_for() {

    }

    @Override
    public void print_geek2() {

    }

    @Override
    void print_geek3() {

    }

}
