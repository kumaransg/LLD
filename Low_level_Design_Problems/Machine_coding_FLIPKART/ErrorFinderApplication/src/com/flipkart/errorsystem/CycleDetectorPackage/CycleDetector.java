package com.flipkart.errorsystem.CycleDetectorPackage;

public class CycleDetector {

	public int dfs(int row,int[][]adjArray,int[]visited,int[]stack) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		if(findInStack(stack,row)==1) 
		{
			return 1;
		};
		if(visited[row]==1) return 0;
		visited[row]=1;

		stack[row]=1;
		for(int i=0;i<adjArray[row].length;i++) {
			if(visited[adjArray[row][i]]!=0) 
			{
				int found=dfs(i,adjArray,visited,stack);
				if(found==1) return 1;
			}
		}
		stack[row]=0;
		return 0;
	}
	
	int findInStack(int[] stack,int row) 
	{
		for(int i=0;i<stack.length;i++) 
		{
			if(stack[i]==row) return 1;
		}
		return 0;
	}
	
}
