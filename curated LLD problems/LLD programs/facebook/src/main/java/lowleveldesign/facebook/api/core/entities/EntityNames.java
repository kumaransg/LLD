package lowleveldesign.facebook.api.core.entities;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("entity_names")
public class EntityNames {

    @PrimaryKeyColumn(name = "person_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Column("entity_name")
    private String entityName; // equivalent of username
    /*
     Q. how keep it unique ?
     A. 1) Bloom Filter to check if not already used when actually not used
        2) Search for in all horizontal partitions
        3) Create a table only containing used entityName partitioned on name.

     */

}
