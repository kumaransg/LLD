package DistributedCache.ConsistentHashing;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private String ipAddress;

    private List<Entry<String, String>> entries;

    public Server(String ipAddress) {
        this.ipAddress = ipAddress;
        entries = new ArrayList<>();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    public void removeEntry(Entry entry) {
        this.entries.remove(entry);
    }

    public List<Entry<String, String>> getEntries() {
        return entries;
    }

    public Entry findEntryForGivenKey(String key) {

        for (Entry e : entries) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return null;
    }
}
