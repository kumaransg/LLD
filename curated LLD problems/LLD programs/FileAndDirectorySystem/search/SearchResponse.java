package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Entry;

import java.util.List;

public class SearchResponse {
    private List<Entry> result;

    public SearchResponse(List<Entry> result) {
        this.result = result;
    }

    public List<Entry> getResult() {
        return result;
    }


    @Override
    public String toString() {
        return "SearchResponse{" +
                "result=" + result +
                '}';
    }
}
