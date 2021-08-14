package DataStructures.LinkedList.Graph;

import java.util.*;

public class UnWeightedShortestPath {
    public static void main(String[] args) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        List<Character> adjA = new ArrayList<>();
        adjA.add('B');
        adjList.put('A',adjA);
        List<Character> adjB = new ArrayList<>();
        adjB.add('C');
        adjB.add('D');
        adjList.put('B',adjB);
        List<Character> adjC = new ArrayList<>();
        adjC.add('E');
        adjList.put('C',adjC);
        List<Character> adjD = new ArrayList<>();
        adjD.add('E');
        adjList.put('D',adjD);
        adjList.put('E',new ArrayList<>());

        bfs(adjList,'A');
    }

    private static void bfs(Map<Character, List<Character>> adjList, Character start){
        int[] distance = new int[256];


        for(Map.Entry<Character, List<Character>> set : adjList.entrySet()){
            distance[set.getKey()] = -1;
        }
        distance[start] = 0;
        Queue<Character> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            Character c = q.poll();
            for(Character ch : adjList.get(c)){
                if(distance[ch] == -1){
                    distance[ch] = distance[c]+1;
                    q.offer(ch);
                }
            }
        }
        for(Map.Entry<Character, List<Character>> set : adjList.entrySet()){
          System.out.println("distance from "+start+" to "+set.getKey()+" = "+distance[set.getKey()]);
      }
    }
}








/*

  a -> b -> c
   \

* */