/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package T9Dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * T9 for Mobile messaging.
 * @author raju rama krishna
 *
 */
public class T9Dictionary {

    private static final Runtime s_runtime = Runtime.getRuntime();

    public static void main(String[] args) throws Exception {

        runGC();
        long heap1 = usedMemory();

        long start = new Date().getTime();
        Trie trie = Trie.getInstance();
        System.out.println("Creating Dictionary");
        File f = new File("/Users/nikhilagrawal/Documents/Design-Pattern/src/DesignPattern/T9Dictionary/data.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s = br.readLine();
        int i = 0;
        do {
            i++;
            String[] split = s.split("\\s+");
            for(int k=0;k<split.length;k++)
            {
                trie.add(split[k]);
            }
            s = br.readLine();
        } while (s != null);
        br.close();
        long end = new Date().getTime();
        long time = (end - start);
        System.out.println("Loaded Dictionary with " + i + " words in " + time + " msec");

        runGC();
        long heap2 = usedMemory(); // take an "after" heap snapshot:
        System.out.println("Memory used = " + (heap2 - heap1));

        String pattern = "255697";
        start = new Date().getTime();
        String word = trie.getWord(pattern);
        end = new Date().getTime();
        time = (end - start);
        System.out.println("Found word : " + word + " in " + time + " msec");

    }

    private static void runGC() throws Exception {
        // for whatever reason it helps to call Runtime.gc()
        // using several method calls:
        for (int r = 0; r < 4; ++r) {
            _runGC();
        }
    }

    private static void _runGC()
            throws Exception {
        long usedMem1 = usedMemory();
        long usedMem2 = Long.MAX_VALUE;

        for (int i = 0; (usedMem1 < usedMem2) && (i < 1000); ++i) {
            s_runtime.runFinalization();
            s_runtime.gc();
            Thread.currentThread().yield();

            usedMem2 = usedMem1;
            usedMem1 = usedMemory();
        }
    }

    private static long usedMemory() {
        return s_runtime.totalMemory() - s_runtime.freeMemory();
    }
}

class Trie {

    private static final String regex = "[a-zA-Z]*";
    private static Trie instance = null;
    Node root = null;
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    private Trie() {
        map.put('a', 2);
        map.put('b', 2);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 3);
        map.put('f', 3);
        map.put('g', 4);
        map.put('h', 4);
        map.put('i', 4);
        map.put('j', 5);
        map.put('k', 5);
        map.put('l', 5);
        map.put('m', 6);
        map.put('n', 6);
        map.put('o', 6);
        map.put('p', 7);
        map.put('q', 7);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 8);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 9);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);
    }

    private int getVal(char c) {
        return map.get(c);
    }

    public static Trie getInstance() {
        if (instance == null) {
            synchronized (Trie.class) {
                instance = new Trie();
            }
        }
        return instance;
    }

    public String getWord(String pattern) {
        String s = null;
        Node node = root;
        int i = 0;
        int num = 0;
        while (i < pattern.length()) {
            num = pattern.charAt(i) - '0';
            if (num == node.val) {
                i++;
                if (i == pattern.length()) {
                    s = node.list.get(0);
                }
                node = node.middle;
            } else if (num < node.val) {
                if (i == pattern.length()) {
                    s = node.list.get(0);
                }
                node = node.left;
            } else {
                if (i == pattern.length()) {
                    s = node.list.get(0);
                }
                node = node.right;
            }

        }
        return s;
    }

    public void add(String s) {
        if (s.length() > 0 && s.matches(regex)) {
            s = s.toLowerCase();
//			System.out.println("Adding : " +s);
            if (root == null) {
                root = new Node(getVal(s.charAt(0)));
                Node node = root;
                Node temp = null;
                for (int i = 1; i < s.length(); i++) {
                    temp = new Node(getVal(s.charAt(i)));
                    node.middle = temp;
                    node = temp;
                    if (i == s.length() - 1) {
                        temp.set(s);
                    }
                }
            } else {
                Node node = root;
                int i = 0;
                Node temp = null;
                int val = 0;
                while (i < s.length()) {
                    val = getVal(s.charAt(i));
                    if (node.val == val) {
                        if (i == s.length() - 1) {
                            node.set(s);
                            i++;
                        } else {
                            i++;
                            if (node.middle == null) {
                                while (i < s.length()) {
                                    val = getVal(s.charAt(i));
                                    temp = new Node(val);
                                    node.middle = temp;
                                    node = temp;
                                    if (i == s.length() - 1) {
                                        temp.set(s);
                                    }
                                    i++;
                                }
                            } else {
                                node = node.middle;
                            }
                        }
                    } else if (val < node.val) {
                        if (node.left == null) {
                            temp = new Node(val);
                            node.left = temp;
                            node = temp;
                            if (i == s.length() - 1) {
                                temp.set(s);
                            } else {
                                i++;
                                while (i < s.length()) {
                                    val = getVal(s.charAt(i));
                                    temp = new Node(val);
                                    node.middle = temp;
                                    node = temp;
                                    if (i == s.length() - 1) {
                                        temp.set(s);
                                    }
                                    i++;
                                }
                            }

                        } else {
                            node = node.left;
                        }
                    } else {
                        if (node.right == null) {
                            temp = new Node(val);
                            node.right = temp;
                            node = temp;
                            if (i == s.length() - 1) {
                                temp.set(s);
                            } else {
                                i++;
                                while (i < s.length()) {
                                    val = getVal(s.charAt(i));
                                    temp = new Node(val);
                                    node.middle = temp;
                                    node = temp;
                                    if (i == s.length() - 1) {
                                        temp.set(s);
                                    }
                                    i++;
                                }
                            }
                        } else {
                            node = node.right;
                        }
                    }
                }
            }
        }
    }
}

class Node {

    int val;
    Node left;
    Node middle;
    Node right;
    List<String> list = new LinkedList<String>();

    public Node(int val) {
        this.val = val;
    }

    public void set(String s) {
        list.add(s);
    }

    public String toString() {
        return String.valueOf(val);
    }
}
