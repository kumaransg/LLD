package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubMatrixThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if(matrix.length==0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count=0;
        Map<Integer,Integer> m = new HashMap<>();
        for(int row = 0; row<rows;row++){
            for(int col=1;col<cols;col++){
                matrix[row][col] += matrix[row][col-1];
            }
        }

        for(int startCol=0;startCol<cols;startCol++){
            for(int currCol=startCol;currCol<cols;currCol++){
                int sum=0;
                m.clear();
                m.put(0,1);
                for(int row=0;row<rows;row++){
                    sum += matrix[row][currCol] - (startCol>0 ? matrix[row][startCol-1]:0);
                    count += m.getOrDefault(sum-target,0);
                    m.put(sum,m.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;

    }
}
