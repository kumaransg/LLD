package LeetCode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int  path[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            path[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            path[0][i]=i;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word1.charAt(i)==word2.charAt(j))
                    path[i+1][j+1]=path[i][j];
                else
                    path[i+1][j+1]= Math.min(path[i+1][j],Math.min(path[i][j],path[i][j+1]))+1;
            }
        }
        return path[m][n];
    }
}
