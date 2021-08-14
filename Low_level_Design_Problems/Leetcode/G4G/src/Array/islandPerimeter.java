package Array;

public class islandPerimeter {

    public int island(int[][] grid) {
        int perimeter=1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    if(i==0 || i==grid.length){
                        perimeter++;
                    }
                    if(j==0 || j==grid[0].length){
                        perimeter++;
                    }

                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] != 1)
                            perimeter++;
                    }
                    if (i + 1 < grid.length) {
                        if (grid[i + 1][j] != 1)
                            perimeter++;
                    }
                    if (j + 1 < grid[0].length) {
                        if (grid[i][j + 1] != 1)
                            perimeter++;
                    }
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] != 1)
                            perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String args[]){
        islandPerimeter ip = new islandPerimeter();
        int[][] island = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int a = ip.island(island);
        System.out.println(a);

    }
}
