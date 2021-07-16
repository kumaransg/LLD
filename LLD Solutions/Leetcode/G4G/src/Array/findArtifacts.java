package Array;

import java.util.*;

public class findArtifacts {

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    // tracking the pieces of artifacts
    HashMap<Integer,int[]> hm = new HashMap<>();
    public int[] solution(int N, String artifacts, String searched) {
        // write your code in Java
        int[][] matrix = new int[N][N];
//forming coordinates
        String[] coordinates = artifacts.split(",");
        String[] searchedCoordinates = null;
        if(searched.contains(","))
            searchedCoordinates = searched.split(" ");
        else
            searchedCoordinates = new String[]{searched};

        int artifactNumber=1;
//filling matrix with artifacts
        for(int i=0;i<coordinates.length;i++){
            String [] cord = coordinates[i].split(" ");
            //"1B 2C,2D 4D"
            //String topLeft = Integer.valueOf(cord[0].charAt(0));
            //String bottomRight = coordinates[i+1];
            //int topRow = Integer.valueOf(cord[0].charAt(0))-'1';
            //int topColumn = cord[0].charAt(1)-'A';
            //int bottomRow = Integer.valueOf(cord[1].charAt(0))-'1';
            //int bottomColumn = cord[1].charAt(1)-'A';
            int [] ar = findRow(cord[0]);
            int topRow = ar[0];
            int topColumn = ar[1];
            ar = findRow(cord[1]);
            int bottomRow = ar[0];
            int bottomColumn = ar[1];
            int count = fillMatrix(matrix,topRow,topColumn,bottomRow,bottomColumn,artifactNumber++);
            hm.put(artifactNumber-1,new int[]{topRow,topColumn,bottomRow,bottomColumn,count});

        }

// Filling searched corrdinates with -10
        //"2B 2D 3D 4D 4A"
        for(int i=0;i<searchedCoordinates.length;i++){
            int[] arr = findRow(searchedCoordinates[i]);
            int row = arr[0];
            int column = arr[1];
            matrix[row][column]=-10;
        }

// search the matrix
        int pointer=1;
        int[] result = new int[2];
        while(pointer<artifactNumber){
            int[] arr = hm.get(pointer);
            int foundPieces = find(arr,pointer,matrix);
            if(arr[4]-foundPieces==arr[4]){
                result[0]++;
            }
            else{
                result[1]=result[1]+(arr[4]-foundPieces);
            }
            pointer++;
        }
        return result;

    }

    private int[] findRow(String coordinates){
        int index=0;
        int num=0;
        while(Character.isDigit(coordinates.charAt(index))){
            num=num*10+coordinates.charAt(index)-'1';
            index++;
        }
        int col = coordinates.charAt(index)-'A';
        return new int [] {num,col};
    }
    private int find(int[] coordinates, int searchArtifact,int[][] matrix){
        int countPieces=0;
        for(int i=coordinates[0];i<=coordinates[2];i++){
            for(int j=coordinates[1];j<=coordinates[3];j++){
                if(matrix[i][j]==searchArtifact){
                    countPieces++;
                }
            }
        }
        return countPieces;
    }
    private int fillMatrix(int[][] matrix, int topRow, int topColumn, int bottomRow, int bottomColumn, int artifactNumber){
        int countPieces=0;
        for(int i=topRow;i<=bottomRow;i++){
            for(int j=topColumn;j<=bottomColumn;j++){
                matrix[i][j]=artifactNumber;
                countPieces++;
            }
        }
        return countPieces;
    }

    public static void main(String args[]){
        findArtifacts fa = new findArtifacts();
        //System.out.println(Arrays.toString(fa.solution(4,"1B 2C,2D 4D","2B 2D 3D 4D 4A")));
        //System.out.println(Arrays.toString(fa.solution(3,"1A 1B,2C 2C","1B")));
        System.out.println(Arrays.toString(fa.solution(12,"1A 2A,12A 12A","12A")));
    }
}