package LeetCode;

import java.util.List;
import java.util.Stack;

public class RoomAndKeys {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] roomsVisited = new int[rooms.size()];
        Stack<Integer> stk = new Stack<>();
        stk.add(0);

        while(!stk.isEmpty()){
            for(int val : rooms.get(stk.pop())){
                if(roomsVisited[val]==0){
                    roomsVisited[val]++;
                    stk.push(val);
                }
            }
        }

        for(int i=1;i<rooms.size();i++){
            if(roomsVisited[i]==0) return false;
        }
        return true;
    }
}
