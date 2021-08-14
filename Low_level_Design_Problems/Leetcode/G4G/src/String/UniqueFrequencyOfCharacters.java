package String;

import java.util.*;

public class UniqueFrequencyOfCharacters {
    public static void main(String [] args){
        String check = "aaabbbccc";
        UniqueFrequencyOfCharacters uf = new UniqueFrequencyOfCharacters();
        int deletions = uf.findNumberOfDeletions(check);
        System.out.println(deletions);
    }

    private int findNumberOfDeletions(String check) {
        // Stores how many times a
        // character occurs. freqOfLetter[0]
        // stores the frequency of letter 'a'
        int[] freqOfLetter;
        char[] s = check.toCharArray();
        freqOfLetter = new int[26];

        for (int i = 0; i < 26; i++)
            freqOfLetter[i] = 0;

        for (int i = 0; i < s.length; i++)
        {
            freqOfLetter[s[i] - 'a']++;
        }

        // Number of characters that
        // have a given frequency
        Map<Integer, Integer > LetterFreqMap = new TreeMap<Integer, Integer >(Collections.reverseOrder());

        for (int i = 0; i < 26; i++)
        {

            // insert the frequency of
            // all lowercase letters in
            // the map that have a
            // frequency greater than 0
            if (freqOfLetter[i] != 0)
            {
                if (LetterFreqMap.containsKey(freqOfLetter[i]))
                {
                    LetterFreqMap.put(freqOfLetter[i],
                            LetterFreqMap.get(freqOfLetter[i]) + 1);
                }
                else
                    LetterFreqMap.put(freqOfLetter[i], 1);
            }
        }

        // Stores the number of
        // deletions needed
        int deletions = 0;

        Set<Map.Entry<Integer,
                Integer>> set = LetterFreqMap.entrySet();
        for (Map.Entry<Integer, Integer> me : set)
        {

            // If frequency is 0
            // then all occurrences
            // have been deleted.
            if (me.getKey() == 0)
                break;

            // Till more than 1
            // character has a
            // given frequency.
            while (me.getValue() > 1)
            {

                // Delete a character
                // that has conflicting
                // frequency
                deletions++;

                // Now 1 less character
                // has the given frequency f
                LetterFreqMap.put(me.getKey(),
                        LetterFreqMap.get(me.getKey()) - 1);

                // But 1 more character
                // has the frequency f - 1
                if (LetterFreqMap.containsKey(me.getKey() - 1))
                {
                    LetterFreqMap.put(me.getKey() - 1,
                            LetterFreqMap.get(me.getKey() - 1) + 1);
                }
                else
                    LetterFreqMap.put(me.getKey() - 1, 1);
            }
        }
        return deletions;
    }
}
