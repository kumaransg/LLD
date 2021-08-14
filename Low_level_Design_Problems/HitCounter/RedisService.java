package HitCounter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisService {

    List<Map<Long, Integer>> ds = new ArrayList<>(3600); // using thread safe array

    public synchronized void request(Instant ts) {
        int index = (int) ts.getEpochSecond() % 3600;
        Map<Long, Integer> recordList = ds.get(index);

        if (recordList == null || recordList.isEmpty()) {
            HashMap<Long, Integer> tmp = new HashMap<>();
            tmp.put(ts.getEpochSecond(), 1);
            ds.add(index, tmp);
        } else {
            Map<Long, Integer> tmp = ds.get(index);
            if (tmp.containsKey(ts.getEpochSecond())) {
                Integer freq = tmp.get(ts.getEpochSecond());
                tmp.put(ts.getEpochSecond(), freq + 1);
            } else {
                tmp.put(ts.getEpochSecond(), 1);
            }
            ds.add(index, tmp);
        }
    }

    public long getCount(Instant ts) {
        long result = 0;

        for (Map<Long, Integer> m : ds) {
            for (Map.Entry<Long, Integer> e : m.entrySet()) {
                if ((ts.getEpochSecond() - e.getKey()) <= 3600){
                    result +=e.getValue();
                }
                else{
                    // cleaning
                    m.remove(e.getKey());
                }
            }
        }
        return result;
    }
}
