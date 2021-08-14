package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Directory;
import FileAndDirectorySystem.Entry;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface SearchCriteria {
    public SearchResponse search(SearchRequest searchRequest, List<Entry> directory);
}
