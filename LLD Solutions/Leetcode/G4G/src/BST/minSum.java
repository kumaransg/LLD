package BST;

import java.io.*;
import java.util.*;

class minSum {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }



    int getCheapestCost(Node rootNode) {
        // your code goes here
        if(rootNode==null)
            return 0;
        return helper(rootNode);
    }

    int helper(Node root){
        if(root==null)
            return 0;
        if(root.children==null)
            return root.cost;
        int min=Integer.MAX_VALUE;
        for(Node node : root.children){
            min = Math.min(min,helper(node));
        }
        return min+root.cost;
    }

//    int getCheapestCost(Node rootNode) {
//        // your code goes here
//        if(rootNode==null)
//            return 0;
//        if(rootNode.children==null)
//            return 0;
//        Node[] children = rootNode.children;
//        int min = Integer.MAX_VALUE;
//        for(Node node : children){
//            min = Math.min(min,helper(node));
//        }
//        return min+rootNode.cost;
//    }
//
//    int helper(Node node){
//        if(node==null)
//            return 0;
//        int s1 = getCheapestCost(node);
//        return s1+node.cost;
//    }


    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        minSum sp = new minSum();
        Node n0 = new Node(0);
        Node n5 = new Node(5);
        Node n3 = new Node(3);
        Node n6 = new Node(6);
        Node n2 = new Node(2);
        Node n00 = new Node(0);
        Node n4 = new Node(4);
        Node n1 = new Node(1);
        Node n55 = new Node(5);
        Node n11 = new Node(1);
        Node n10 = new Node(10);

        Node n111 = new Node(1);

        Node[] children0 = {n5,n3,n6};
        Node[] children5 = {n4};
        Node[] children3 = {n2,n00};
        Node[] children6 = {n1,n55};
        Node[] children2 = {n11};
        Node[] children00 = {n10};
        Node[] children11 = {n111};
        n0.children = children0;
        n5.children = children5;
        n3.children = children3;
        n6.children = children6;
        n2.children = children2;
        n00.children = children00;
        n11.children = children11;
        System.out.println(sp.getCheapestCost(n0));
    }
}
