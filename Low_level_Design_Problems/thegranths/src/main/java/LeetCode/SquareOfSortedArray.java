package LeetCode;

public class SquareOfSortedArray {
    public int[] sortedSquares(int[] A) {

        int positive=0;
        while(positive<A.length && A[positive]<0) positive++;

        int negative = positive-1;
        int i=0;
        int[] result = new int[A.length];
        while(negative>= 0 && positive<A.length){
            if(A[negative]*A[negative] > A[positive]*A[positive]){
                result[i++]=A[positive]*A[positive];
                positive++;
            }else {
                result[i++]=A[negative]*A[negative];
                negative--;
            }
        }

        while(negative>=0){
            result[i++]=A[negative]*A[negative];
            negative--;
        }

        while(positive<A.length){
            result[i++]=A[positive]*A[positive];
            positive++;
        }

        return result;
    }
}
