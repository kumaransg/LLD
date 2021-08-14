package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Entry;

import java.util.List;

public class SearchRequest {
    Double minSize;
    String pattern;
    String format;

    public SearchRequest(Double minSize, String pattern) {
        this.minSize = minSize;
        this.pattern = pattern;
    }

    public SearchRequest(Double minSize, String pattern, String format) {
        this.minSize = minSize;
        this.pattern = pattern;
        this.format = format;
    }

    public Double getMinSize() {
        return minSize;
    }

    public String getPattern() {
        return pattern;
    }

    public String getFormat() {
        return format;
    }
}
