package Array;
import java.util.*;

public class reconstructItenary {

    HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
    List<String> route = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> ls: tickets){
            hm.putIfAbsent(ls.get(0),new PriorityQueue<>());
            hm.get(ls.get(0)).add(ls.get(1));
        }
        dfs("JFK");
        return route;
    }
    public void dfs(String departure){
        PriorityQueue<String> p = hm.get(departure);
        if(p!=null && !p.isEmpty()){
            dfs(p.poll());
        }
        route.add(0,departure);
    }


    public static void main(String args[]){
    reconstructItenary r = new reconstructItenary();
        List<List<String>> ls =  new ArrayList<List<String>>();

        List<String> ls2 = new ArrayList<>();
        ls2.add("MUC");
        ls2.add("LHR");
        ls.add(ls2);
        ls2 = new ArrayList<>();
        ls2.add("JFK");
        ls2.add("MUC");
        ls.add(ls2);
        ls2 = new ArrayList<>();
        ls2.add("SFO");
        ls2.add("SJC");
        ls.add(ls2);
        ls2 = new ArrayList<>();
        ls2.add("LHR");
        ls2.add("SFO");
        ls.add(ls2);

        ls2 = r.findItinerary(ls);
        System.out.println(Arrays.deepToString(ls2.toArray()));
    }
}
