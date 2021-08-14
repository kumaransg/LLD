package String;

import java.io.*;
import java.util.*;

//input:  dict = {
//        "Key1" : "1",
//        "Key2" : {
//        "a" : "2",
//        "b" : "3",
//        "c" : {
//        "d" : "3",
//        "e" : {
//        "" : "1"
//        }
//        }
//        }
//        }
//
//        output: {
//        "Key1" : "1",
//        "Key2.a" : "2",
//        "Key2.b" : "3",
//        "Key2.c.d" : "3",
//        "Key2.c.e" : "1"
//        }

public class FlattenDictionary {

    static HashMap<String,String> hm = new HashMap<>();

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        if(dict.size()==0)
            return hm;
        hm = new HashMap<>();

        helper("",dict,true);
        return hm;
    }


    private static void helper(String parentKey, Object object, boolean first){
        if(object instanceof Integer || object instanceof String || object instanceof Double){
            String value = String.valueOf(object);
            hm.put(parentKey,value);
            return;
        }
        HashMap<String,Object> childDict = (HashMap<String, Object>) object;
        //first = truel
        for(String key: childDict.keySet()){
            //parentKey+= parentKey.length()==0?"":".";
            if(first){
                //first = false;
                helper(key,childDict.get(key),false);
            }
            else{
                helper(parentKey+"."+key,childDict.get(key),first);
            }

        }
    }

    public static void main(String[] args) {
        HashMap<String,Object> send = new HashMap<>();
        send.put("key1",1);
        HashMap<String,Object> e = new HashMap<>();
        e.put("","1");
        HashMap<String,Object> c = new HashMap<>();
        c.put("d",3);
        c.put("e",e);

        HashMap<String,Object> key2 = new HashMap<>();
        key2.put("a",2);
        key2.put("b",3);
        key2.put("c",c);
        send.put("key2",key2);
        HashMap<String,String> hm2 = flattenDictionary(send);

        for(String key: hm2.keySet()){
            System.out.println(key+":"+hm2.get(key));
        }
    }

}



//        Test Case #1
//        Input: {"Key1":"1","Key2":{"a":"2","b":"3","c":{"d":"3","e":"1"}}},Expected: {"Key1":"1","Key2.a":"2","Key2.b":"3","Key2.c.d":"3","Key2.c.e":"1"},Actual: {Key2.c.d=3, Key2.c.e=1, Key1=1, Key2.a=2, Key2.b=3}
//        Test Case #2
//        Input: {"Key":{"a":"2","b":"3"}},Expected: {"Key.a":"2","Key.b":"3"},Actual: {Key.a=2, Key.b=3}
//        Test Case #3
//        Input: {"Key1":"1","Key2":{"a":"2","b":"3","c":{"d":"3","e":{"f":"4"}}}},Expected: {"Key1":"1","Key2.a":"2","Key2.b":"3","Key2.c.d":"3","Key2.c.e.f":"4"},Actual: {Key2.c.d=3, Key1=1, Key2.a=2, Key2.b=3, Key2.c.e.f=4}
//        Test Case #4
//        Input: {"":{"a":"1"},"b":"3"},
//        Expected: {"a":"1","b":"3"},
//        Actual: {b=3, .a=1}
//        Test Case #5
//        Input: {"a":{"b":{"c":{"d":{"e":{"f":{"":"awesome"}}}}}}},Expected: {"a.b.c.d.e.f":"awesome"},Actual: {a.b.c.d.e.f.=awesome}
//        Test Case #6
//        Input: {"a":"1"},Expected: {"a":"1"},Actual: {a=1}