package sorting.MergeSort;

public class MergeSort<X extends Comparable<X>> {

    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        //TODO stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]

        int i=lo, j=mid+1;
        for(int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }

        for(int k=lo;k<=hi;k++){
            if(i>mid)
                a[k]=aux[j++];
            else if (j>hi)
                a[k]=aux[i++];
            else if(less(aux[i],aux[j]))
                a[k]=aux[i++];
            else
                a[k]=aux[j++];
        }

    }

    public static int[] sort(int[] a) {
        //TODO sorting without recursion
        int N = a.length;
        int [] aux = new int[N];
        for (int sz = 1; sz < N; sz = sz+sz)
            for (int lo = 0; lo < N-sz; lo += sz+sz)
                merge(a,aux,lo,lo+sz-1,Math.min(N-1,lo+sz+sz-1));
        //TODO
        return a;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private MergeSort() { }

    public static void main(String args[]){
        int[] test = {5,2,3,4,2,3,4,1};
        int[] result = MergeSort.sort(test);
        Integer[] answer = {1,2,2,3,3,4,4,5};
        System.out.println(result);
        //assertArrayEquals(answer,result);

    }

}