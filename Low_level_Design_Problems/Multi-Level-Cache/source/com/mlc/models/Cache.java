package com.mlc.models;

public class Cache extends LRUCache {
    private int readTime;
    private int writeTime;
    private int priority;

    public Cache(int capacity, int readTime, int writeTime, int priority) {
        super(capacity);
        this.readTime = readTime;
        this.writeTime = writeTime;
        this.priority = priority;
    }

    public int getReadTime() {
        return readTime;
    }

    public int getWriteTime() {
        return writeTime;
    }

    public int getPriority() {
        return priority;
    }
}