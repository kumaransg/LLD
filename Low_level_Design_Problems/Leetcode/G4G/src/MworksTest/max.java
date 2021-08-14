package MworksTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class max {


    /*
     * Complete the 'getMaxStreaks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY toss as parameter.
     */

    public static List<Integer> getMaxStreaks(List<String> toss) {
        // Return an array of two integers containing the maximum streak of heads and tails respectively

        int maxHead=0, maxTails=0, heads=0, tails=0;
        String last = toss.get(0);
        if(last.equals("Heads")) {
            heads++;
        }
        else {
            tails++;
        }

        int i=1;
        while(i<toss.size()){
            if(toss.get(i)!=last){
                maxHead=Math.max(maxHead,heads);
                maxTails=Math.max(maxTails,tails);
                System.out.println(last +":"+heads+"---"+tails);
                heads=0;
                tails=0;
                last = toss.get(i);
            }
            else{

                if(last.equals("Heads")) {
                    //heads++;
                    heads=heads+1;
                    System.out.println(heads+"hhhhh"+tails);
                }
                else {
                    tails++;
                    System.out.println(heads+"tttt"+tails);
                }
                i++;

            }
        }

        List<Integer> ls = new ArrayList<>();
        ls.add(maxHead);
        ls.add(maxTails);
        return ls;

    }



    public static void main(String[] args) throws IOException {
    List<String> ls = new ArrayList<>();
    ls.add("Heads");
    ls.add("Tails");
    ls.add("Tails");
    ls.add("Tails");
    ls.add("Heads");
    ls.add("Heads");
    ls.add("Tails");
    List<Integer> ls2 = new ArrayList<>();
    ls2 = getMaxStreaks(ls);
    System.out.println(Arrays.asList(ls2));

    }
}
