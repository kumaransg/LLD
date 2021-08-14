package santanu.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@AllArgsConstructor
public class ParserForFlipkart<T> {
    private Class target;
    private String filename;

    public List<T> parse() throws Exception {
        CsvToBean<T> beans = new CsvToBeanBuilder<T>(getReader(filename))
                .withMappingStrategy(getMappingStrategy())
                .build();
        return beans.parse();
    }
    private Reader getReader(String filename) throws FileNotFoundException {
        return new FileReader(new Main().getClass().getClassLoader().getResource(filename).getFile());
    }

    private MappingStrategy<T> getMappingStrategy() {
        MappingStrategy<T> ms = new HeaderColumnNameMappingStrategy<T>();
        ms.setType(target);
        return ms;
    }
}
