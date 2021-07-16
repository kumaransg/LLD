package dfs;

import java.io.*;
import java.util.*;

class findMinLen {
    static int min=Integer.MAX_VALUE;
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        min=Integer.MAX_VALUE;
        if(grid.length==0)
            return -1;

        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]!=1)
            return -1;

        explore(grid,sr,sc,tr,tc , 0);

        if(min==Integer.MAX_VALUE)
            return -1;

        return min;
    }

    static void explore(int[][] grid, int sr, int sc, int tr, int tc , int count){

        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]!=1 || grid[sr][sc]==-1)
            return;

        if(sr==tr && sc==tc){
            min = Math.min(count,min);
            //System.out.println("Here");
            return;
        }


        int prev = grid[sr][sc];
        grid[sr][sc]=-1;
        explore(grid,sr,sc+1,tr,tc,count+1);
        explore(grid,sr+1,sc,tr,tc,count+1);
        explore(grid,sr-1,sc,tr,tc,count+1);
        explore(grid,sr,sc-1,tr,tc,count+1);
        grid[sr][sc]=prev;
        return;
    }

    public static void main(String[] args) {
        findMinLen sol = new findMinLen();
        int[][] grid = {{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}};
        int sr = 0, sc = 0, tr = 2, tc = 0;
        int res = sol.shortestCellPath(grid, sr, sc, tr, tc);
        System.out.println(res);
    }
}
