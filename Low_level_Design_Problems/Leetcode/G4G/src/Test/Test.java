package Test;

import FileSearch.FileSearch;
import Trie.WordDictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.IntStream;

public class Test extends TestParent {
    public static void main(String[] args) throws IOException {
//        int b = 22;
//        String a = String.valueOf(b);
//        System.out.println(b);
//        List<List<String>> ls = new ArrayList<>();
//        int[] arr = new int[2];
//        Arrays.fill(arr,1);
//        arr[0]^=256;
//        arr[0]^=256;
//        arr[0]^=256;
//        StringBuilder sb = new StringBuilder();
//        sb.append('1');
//        HashMap<String,TreeMap<Integer,String>> hm = new HashMap<>();
//        TreeMap <Integer,String>tm = hm.get(1);
//        HashSet<Character> hs = new HashSet<>();
//        String ab ="wef";
//        char [] c = ab.toCharArray();
//        hs = new HashSet(Arrays.asList(c));
//        //hs = new HashSet(Arrays.asList("ererg"));
//        hs.add('a');
//        List<Character> cd = new ArrayList<Character>();
//        cd.add('a');
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        HashMap<Integer,Integer>hm2 = new HashMap<>();
//        int test = 1;
//        pq.add(test);
//        hm2.put(1,test);
//
//        test = 4;
//
//
//        System.out.println(test);
//        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
//        lhs.add(1);
//        lhs.add(2);
//        boolean am = lhs.iterator().hasNext();
//        System.out.println(am);
//        Random rand = new Random();
//        int[] aaa= {1};
//        int[] bbb = Arrays.copyOf(aaa,aaa.length);
//        List<List<Integer>> ls2 = new ArrayList<>();
//
//        List<List<String>> ls = new ArrayList<>();
//        HashMap<String,List<String>> hm = new HashMap<>();
//        String[] strs = {"Hello","World"};
//        for(String word: strs){
//            char[] c = word.toCharArray();
//            Arrays.sort(c);
//            String w = Arrays.toString(c);
//            if(!hm.containsKey(w))
//                hm.put(w,new ArrayList<String>());
//            hm.get(w).add(word);
//        }
//        int[][] dp = new int[2][2];
//
//        List<Integer> ls2 = new ArrayList<>();
//        ls2.add(1);
//        ls2.add(1);
//        TreeMap<Integer,Integer> tm = new TreeMap<>();
//        StringBuilder sb = new StringBuilder();
//        sb.append(1);
//        HashSet<String> hs = new HashSet<>();
//        sb.setLength(0);
//        String data = "ABCD";
//        String[] separate = data.split(",");
//
//        List<Integer> ls3 = new ArrayList(Arrays.asList(separate));
//        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> (a.getValue()-b.getValue()));
//        HashSet<List<Integer>> ls22 = new HashSet<>();
//
//        String first = ": :";
//        String[] f = first.split(" ",1);
//
//        int previous = first.charAt(0);
//        String wordss = "google.mail.com";
//        String s= "mail";
//        System.out.println(wordss.indexOf(s));
//        String domains = "9001 discuss.leetcode.com";
//        String[] domain = domains.split(" ");
//        String[] d = domain[1].split("//.");
//        System.out.println(Arrays.toString(d));
//        System.out.println(Arrays.toString(domain));
//        char[] chars ={'a'};
//        int count = 1;
//        chars[0]= Character.highSurrogate(count);
//        TreeSet<Integer> ts = new TreeSet<>();
//
//        Test.print();
//        TestParent.print();
//        Test test = new Test();
//        test.printParent();
//        test.printParent();
//        int[] array = { 10, 20, 30 };
//        IntStream stream = Arrays.stream(array);
//        // ... Call anyMatch on the IntStream.
//        boolean result = stream.anyMatch(number -> number >= 25);
//        System.out.println(result);

//        File file = new File("/Users/ajaygoel/Documents/TA/config.txt");
//        if(file.createNewFile()){
//            System.out.println("File created");
//        }
//        else{
//            System.out.println("Not created");
//        }
//
//        File scnd = new File("/Users/ajaygoel/Documents"+file.getName());
//
//        FileInputStream fis = new FileInputStream(file);
//        FileOutputStream fos = new FileOutputStream(scnd);
//        int b;
//        while((b=fis.read())!=-1){
//            fos.write(b);
//        }
//        fis.close();
//        fos.close();


        File file = new File("/Users/ajaygoel/Documents/TA/config.txt");
        Path p = file.toPath();
        Path paths = Paths.get("/Users/ajaygoel/Documents/"+file.getName());
        Files.copy(p,paths,StandardCopyOption.REPLACE_EXISTING);



    }

    static void print(){
        System.out.println("Here");
    }

    private void printParent(){
        System.out.println("Here in print child");
    }
}