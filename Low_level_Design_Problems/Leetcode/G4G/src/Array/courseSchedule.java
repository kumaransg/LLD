package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    boolean bfs(int courses, int[][]prereq){
        ArrayList[] graph = new ArrayList[courses];
        int count=0;
        int [] degree = new int[courses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<courses;i++)
            graph[i]= new ArrayList();

        for(int i=0;i<prereq.length;i++){
            graph[prereq[i][0]].add(prereq[i][1]);
            degree[prereq[i][1]]++;
        }

        for(int i=0;i<courses;i++){
            if(degree[i]==0) {
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int course = q.poll();
            for(int i=0;i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer]==0){
                    q.offer(pointer);
                    count++;
                }
            }
        }
        if(count==courses)
            return true;
        return false;

    }
    public static void main(String args[]){
        courseSchedule cs = new courseSchedule();
        int [][] arr = {{1,0},{0,1}};
        boolean res = cs.canFinish(2,arr); //dfs
        boolean res2 = cs.bfs(2,arr); //bfs
        System.out.println(res);
        System.out.println(res2);
    }
}
