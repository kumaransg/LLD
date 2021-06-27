package DataStructures.LinkedList.Graph;

import java.util.*;

public class DijkstraAlgorithm {
    int dist[] = new int[5];
    PriorityQueue<Node> pq =new PriorityQueue<>((n1,n2) -> {
        if (n1.cost < n2.cost)
            return -1;
        if (n1.cost > n2.cost)
            return 1;
        return 0;});

    public static void main(String[] args) {
       int numVertex = 5;
       int srcVertex = 0;
       List<List<Node>> adjList = new ArrayList<>();
       for(int i=0;i<numVertex;i++){
           adjList.add(new ArrayList<>());
       }

        adjList.get(0).add(new Node(1, 9));
        adjList.get(0).add(new Node(2, 6));
        adjList.get(0).add(new Node(3, 5));
        adjList.get(0).add(new Node(4, 3));

        adjList.get(2).add(new Node(1, 2));
        adjList.get(2).add(new Node(3, 4));
        DijkstraAlgorithm dj = new DijkstraAlgorithm();
        dj.dijkstra(adjList,srcVertex);
        for(int i=0;i<5;i++){
            System.out.println("distance from 0 to "+i+" = "+dj.dist[i]);
        }

    }

    private  void dijkstra( List<List<Node>> adjList, int srcVertex){

        for(int i=0;i<5;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        pq.offer(new Node(srcVertex,0));
        dist[srcVertex] = 0;

        while(!pq.isEmpty()){
            int currVertex = pq.poll().node;
            for(int i=0;i<adjList.get(currVertex).size();i++){
                Node nextVertex = adjList.get(currVertex).get(i);
                int newDistance = dist[currVertex] + nextVertex.cost;

                if(dist[nextVertex.node]> newDistance)
                    dist[nextVertex.node] = newDistance;

                pq.offer(new Node(nextVertex.node,dist[nextVertex.node]));
            }
        }
    }


}

class Node {
    public int node;
    public int cost;

    public Node()
    {
    }

    public Node(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }
}