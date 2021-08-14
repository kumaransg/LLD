package FileAndDirectorySystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private List<Entry> entries; // this will contains files and sub directories

    public Directory() {
        this.entries = new ArrayList<>();
    }

    public boolean add(Entry entry) {
        for (Entry e : entries) {
            if (e.getName().equalsIgnoreCase(entry.getName())) {
                return false;
            }
        }
        entries.add(entry);
        return true;
    }

    public boolean delete(String name) {
        boolean result = false;
        for (Entry e : entries) {

            // For directory
            if (e instanceof Directory) {
                result = ((Directory) e).delete(name);
            }

            if (result) {
                return true;
            }

            // for File
            if (e.getName().equalsIgnoreCase(name)) {
                entries.remove(e);
                return true;
            }
        }
        return false;
    }

    public Integer totalSize() {
        int totalSize = 0;
        for (Entry e : entries) {

            // For directory
            if (e instanceof Directory) {
                totalSize += ((Directory) e).totalSize();
            } else {
                totalSize += ((File) e).getSize();
            }
        }
        return totalSize;
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
