package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    Map<String,List<String>> memoryMap = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s==null||s.length()==0) return result;

        if(memoryMap.containsKey(s)){
            return memoryMap.get(s);
        }

        if(wordDict.contains(s)){
            result.add(s);
        }

        for(int i=1; i<s.length();i++){
            String tmp = s.substring(i);
            if(wordDict.contains(tmp)){
                List<String> temp = wordBreak(s.substring(0,i),wordDict);
                if(temp.size()>0){
                    for(int j=0;j<temp.size();j++){
                        result.add(temp.get(j)+" "+tmp);
                    }
                }
            }
        }
        memoryMap.put(s,result);
        return result;
    }
}
