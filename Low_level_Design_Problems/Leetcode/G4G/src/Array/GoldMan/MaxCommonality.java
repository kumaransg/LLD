package Array.GoldMan;


public class MaxCommonality {


    private static int findMaxCommonality(String str) {
        int[] count = new int[26];
        for(char ch : str.toCharArray()) {
            count[ch-'a']++;
        }
        int res = 0;
        int cur = 0;
        for(int i=0; i<str.length(); ++i) {
            if(count[str.charAt(i)-'a'] > 1) {
                ++cur;
                count[str.charAt(i)-'a'] -= 2;
            } else if (count[str.charAt(i)-'a'] == 0) {
                --cur;
            } else {
                --count[str.charAt(i)-'a'];
            }
            res = Math.max(cur, res);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(findMaxCommonality("abcdedeara"));
    }

}
