public class GenericBound {

    public static <T extends Comparable<T>> int toCompare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    public static<N extends Number> Number addition(N n1, N n2){
        return n1.intValue()+n2.intValue();
    }
}
