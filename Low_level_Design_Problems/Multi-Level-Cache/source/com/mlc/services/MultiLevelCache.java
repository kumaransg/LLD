package com.mlc.services;

import com.mlc.models.*;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class MultiLevelCache {
    PriorityQueue<Cache> pq;

    public MultiLevelCache(int numLayers) {
        this.pq = new PriorityQueue<Cache>(numLayers, new CacheComparator());
    }

    public void addLayer(String capacity, String readTime, String writeTime, int priority) {
        int cap = Integer.parseInt(capacity);
        int rt = Integer.parseInt(readTime);
        int wt = Integer.parseInt(writeTime);

        pq.add(new Cache(cap, rt, wt, priority));
    }

    public int write(String val) {
        Iterator itr = pq.iterator();
        int totalWriteTime = 0;
        while(itr.hasNext()) {
            Cache curLevelCache = (Cache) (itr.next());
            boolean didWrite = curLevelCache.write(val);
            if(didWrite) {
                totalWriteTime += curLevelCache.getWriteTime();
            }
        }
        return totalWriteTime;
    }

    public int read(String val) {
        Iterator itr = pq.iterator();
        int totalReadTime = 0;
        int readTillIndex = -1;
        boolean foundElement = false;
        Cache curLevelCache;
        while(itr.hasNext() && !foundElement) {
            curLevelCache = (Cache) (itr.next());
            foundElement = curLevelCache.read(val);
            totalReadTime += curLevelCache.getReadTime();
            readTillIndex++;
        }
        itr = pq.iterator();
        int curWriteIndex = 0;
        while(itr.hasNext() && curWriteIndex < readTillIndex) {
            curLevelCache = (Cache) (itr.next());
            boolean didWrite = curLevelCache.write(val);
            if(didWrite) {
                totalReadTime += curLevelCache.getWriteTime();
            }
        }
        return totalReadTime;
    }

    public List<Integer> getCacheSize() {
        List<Integer> cacheSizes = new ArrayList<Integer>();
        Iterator itr = pq.iterator();
        while(itr.hasNext()) {
            Cache curLevelCache = (Cache) (itr.next());
            cacheSizes.add(curLevelCache.getFilledSize());
        }
        return cacheSizes;
    }
}

class CacheComparator implements Comparator<Cache> {
    public int compare(Cache c1, Cache c2) {
        if(c1.getPriority() < c2.getPriority()) {
            return 1;
        } else if(c1.getPriority() > c2.getPriority()) {
            return -1;
        }
        return 0;
    }
}