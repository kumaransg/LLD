package FileAndDirectorySystem;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Entry {

    private String name;
    private Date updatedTs;
    private Date lastAccessTs;
    private Date createdTs;
    private Double size;

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdatedTs(Date updatedTs) {
        this.updatedTs = updatedTs;
    }

    public void setLastAccessTs(Date lastAccessTs) {
        this.lastAccessTs = lastAccessTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Date getUpdatedTs() {
        return updatedTs;
    }

    public Date getLastAccessTs() {
        return lastAccessTs;
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public Double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                '}';
    }
}
