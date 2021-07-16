package Array;

// Click on "HELP" above to see examples of handling input/debug/output
// Format the output as specified in the problem statement and write the result to stdout
// IMPORTANT: Remove all debug statements for your final submission
import java.io.IOException;
import java.util.*;

class GumballProblem {
    static int numberOfMachines = 3;
    // Bootstrap code {
//    public static void main(String args[]) throws IOException {
//        double totalMinWastage = 0d;
//        List<String> a = new ArrayList<String>();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String input = in.nextLine();
//        a = Arrays.asList(input.split(" "));
//        totalMinWastage = minimumWastageCost(a);
//        System.out.println(totalMinWastage);
//    }
    // }

    public static double minimumWastageCost(List<String> a) {
        double totalWastage = 0;
        HashMap<String,Integer> hm = new HashMap<>();
        //     // Write your code here
        int index=0;
        int N = a.size();
        double min=0;
        while(N>=1){
            System.out.println("Before");
            N--;
            if(hm.containsKey(a.get(index)))
                hm.put(a.get(index), 1000);
            else
            {
                if(hm.size()==3 && !hm.containsKey(a.get(index))){
                    String color = findMinimum(hm);
                    //System.out.println(color);
                    if(!hm.containsKey(color))
                        continue;
                    min+=hm.get(color);
                }
                hm.put(a.get(index),1000);
            }
            reduceGums(hm);
            index++;
            //System.out.println("Before 2");
        }
        return min/100;
    }

    public static void reduceGums(HashMap<String, Integer> hm){
        for(String col: hm.keySet()){
            hm.put(col,hm.get(col)-10);
        }
    }

    public static String findMinimum(HashMap<String, Integer> hm){
        int min=1001;
        String col="";
        for(String color: hm.keySet()){
            if(hm.get(color)<min){
                min=hm.get(color);
                col=color;
            }
        }
        return col;
    }

    public static void main(String[] args){
        GumballProblem gp = new GumballProblem();
        List<String> color = new ArrayList<>();
        color.add("red");
        color.add("green");
        color.add("blue");
        color.add("red");
        color.add("white");
        double res = gp.minimumWastageCost(color);
        System.out.println(res);
    }
}