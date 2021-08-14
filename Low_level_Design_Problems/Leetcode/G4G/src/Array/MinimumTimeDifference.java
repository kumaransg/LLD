package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {
    private class superComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String[] one = a.split(":");
            String[] two = b.split(":");
            return one[1].compareTo(two[1]);
        }
    }
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new superComparator());
        String two = timePoints.get(1).substring(3);
        String one = timePoints.get(0).substring(3);

        System.out.println(two);
        System.out.println(one);
        if(two.equals("00"))
            two="60";
        if(one.equals("00"))
            one="60";

        return Math.abs(Integer.valueOf(two)-Integer.valueOf(one));
    }

    public static void main(String args[]){
        MinimumTimeDifference mtd = new MinimumTimeDifference();
        List<String> ls = new ArrayList<>();
        ls.add("23:59");
        ls.add("00:00");
        int a = mtd.findMinDifference(ls);
        System.out.println(a);
    }
}
