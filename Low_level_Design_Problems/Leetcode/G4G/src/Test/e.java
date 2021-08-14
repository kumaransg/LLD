//import java.io.*;
//import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//
//class Solution {
//    class Key {
//        String key;
//        Key(String key){
//            this.key=key;
//        }
//        @override
//        public int hashcode(){
//            int hash = (int)key.charAt(0);
//            return hash;
//        }
//        @override
//        public boolean equals(Object key){
//            return key.equals(((Object)key).key);
//        }
//    }
//
//    List<String> keys;
//    List<Integer> values;
//
//    public Solution(){
//        keys = new ArrayList<>();
//        values = new ArrayList<>();
//    }
//
//
//    public void put(String key, int value){
//
//        Key hashValue = new Key(key);
//        if(!hashValue.equals(key)){
//            keys.add(key);
//            values.add(value);
//        }
//        int index = keys.indexOf(key);
//        values.set(index,value);
//    }
//    public int get(String key){
//
//        if(keys.contains(key)){
//            return values.get(keys.indexOf(key));
//        }
//        return -1;
//    }
//
//
//
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        Key k = new Key("Ajay");
//        sol.put("Ajay",1);
//
//        // System.out.println(sol.get("Ajay"));
//        // sol.put(null,1);
//        // sol.get(null);
//        m.put(new Solution("Ajay",1));
//
////     ArrayList<String> strings = new ArrayList<String>();
////     strings.add("Hello, World!");
////     strings.add("Welcome to CoderPad.");
////     strings.add("This pad is running Java " + Runtime.version().feature());
//
////     for (String string : strings) {
////       System.out.println(string);
////     }
//    }
//}
