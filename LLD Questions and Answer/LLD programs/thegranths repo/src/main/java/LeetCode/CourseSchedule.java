package LeetCode;

import java.util.*;

public class CourseSchedule {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] inDegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        inDegree = new int[numCourses];
        populateMap(numCourses,prerequisites);
        Queue<Integer> q = new LinkedList<>();

        int count=0;
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int val = q.poll();
            count++;
            for(int sub: map.get(val)){
                inDegree[sub]--;
                if(inDegree[sub]==0) q.add(sub);
            }
        }


        return count==numCourses;
    }


    private void populateMap(int numCourses, int[][] prerequisites){
        for(int i=0;i< numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int crs = pre[1];
            int dependant = pre[0];
            List<Integer> l = map.get(crs);
            l.add(dependant);
            map.put(crs,l);
            inDegree[dependant]++;

        }
    }
}
