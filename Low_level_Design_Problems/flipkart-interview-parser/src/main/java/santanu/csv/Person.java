package santanu.csv;
import com.opencsv.bean.CsvBindByName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "age")
    private int age;

    @CsvBindByName(column = "salary")
    private double salary;

    @Override
    public String toString() {
        return "" + id + " " + name + " " + age + " " + salary;
    }
}
