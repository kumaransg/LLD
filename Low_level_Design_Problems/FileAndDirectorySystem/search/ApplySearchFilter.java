package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Entry;

import java.util.List;

public class ApplySearchFilter implements SearchCriteria {

    private SearchByFileName searchByFileName;
    private SearchByFormat searchByFormat;
    private SearchBySize searchBySize;

    public ApplySearchFilter() {
        searchByFileName = new SearchByFileName();
        searchByFormat = new SearchByFormat();
        searchBySize = new SearchBySize();
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest, List<Entry> entries) {
        SearchResponse searchResponse = searchByFileName.search(searchRequest, entries);
        searchResponse = searchBySize.search(searchRequest, searchResponse != null ? searchResponse.getResult() : entries);
        searchResponse = searchByFormat.search(searchRequest, searchResponse != null ? searchResponse.getResult() : entries);
        return searchResponse;
    }
}
