package cache.model;

/**
 * @author priyamvora
 * @created 03/05/2021
 */
public class LevelCacheData {
    private final Integer readTime;
    private final Integer writeTime;

    public LevelCacheData(Integer readTime, Integer writeTime) {
        this.readTime = readTime;
        this.writeTime = writeTime;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public Integer getWriteTime() {
        return writeTime;
    }
}
