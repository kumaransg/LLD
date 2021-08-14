package String;

import java.util.*;

public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                for (int i = 0; i < endWord.length(); i++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder newWord = new StringBuilder(cur);
                        newWord.setCharAt(i, letter);
                        if (set.contains(newWord.toString())) {
                            if (newWord.toString().equals(endWord)) return step + 1;
                            set.remove(newWord.toString());
                            q.offer(newWord.toString());
                        }
                    }
                }

            }
            step++;
        }
        return 0;
    }

    public static void main(String args[]){
        wordLadder wl = new wordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> ls = new ArrayList<>();
        ls.add("hot");
        ls.add("dot");ls.add("dog");ls.add("lot");ls.add("log");ls.add("cog");
        int a = wl.ladderLength(beginWord,endWord,ls);
        System.out.println(a);
    }
}
