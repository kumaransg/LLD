package connect4;

import connect4.dao.GameDao;
import connect4.model.*;
import jdk.nashorn.internal.parser.JSONParser;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;

/**
 * @author priyamvora
 * @created 15/05/2021
 */
public class Driver {
//    public static void main(String[] args) throws IOException {
////        GameDao gameDao = new GameDao(6, 7, 4);
////        Player player = new Player(new User("1", "priyam", "priyam@hike.in"), new RedBallType());
////        Player player2 = new Player(new User("2", "priyam2", "priyam2@hike.in"), new YellowBallType());
////        gameDao.addPlayer(player);
////        gameDao.addPlayer(player2);
////
////        Move move = gameDao.makeMove(6);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(6);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(5);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(6);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(5);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(6);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(6);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(6);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(4);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(5);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(4);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(5);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(4);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(1);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(3);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(3);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(3);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(1);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////        move = gameDao.makeMove(3);
////        System.out.println(move);
////        System.out.println(gameDao.checkForWin(move.getRow(), move.getCol()));
////
//
//        URL url = new URL("https://api.pro.coinbase.com/products");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Content-Type", "application/json");
//        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//        con.connect();
//        System.out.println(con.getResponseCode());
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer content = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine);
//        }
//        in.close();
//        con.disconnect();
//        System.out.println(content);
//    }

    static ArrayList<Node>[] adj;

    public static void main(String[] args) {
        adj = new ArrayList[100];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Node>();
        }
        addEdge(0, 1, 1000, 990);
        addEdge(0, 2, 1200, 1150);
        addEdge(3, 1, 200, 180);
        addEdge(3, 2, 220, 210);


        int src = 1;
        double initialAmount = 100.0;
        int dest = 2;
        double maxCost = 0;
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(src, initialAmount);
        queue.add(start);
        while (!queue.isEmpty()){
            Node top = queue.poll();
            if(top.dest == dest){
                maxCost = Math.max(maxCost, top.weight);
            }
            for(Node nei: adj[top.dest]){
                System.out.println(top + " " + nei);
                if(!top.vertices.contains(nei.dest)){
                    Node temp = new Node(nei.dest, top.weight * nei.weight);
                    temp.vertices.addAll(top.vertices);
                    temp.vertices.add(top.dest);
                    queue.add(temp);
                }
            }
        }
        System.out.println(maxCost);
    }

    private static void addEdge(int src, int dest, int ask, int bid) {
        adj[dest].add(new Node(src, 1.0 / ask));
        adj[src].add(new Node(dest, (double) bid));
    }
}

class Node {
    int dest;
    Double weight;
    Set<Integer> vertices;

    public Node(int dest, Double weight) {
        this.dest = dest;
        this.weight = weight;
        this.vertices = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "dest=" + dest +
                ", weight=" + weight +
                ", vertices=" + vertices +
                '}';
    }
}
